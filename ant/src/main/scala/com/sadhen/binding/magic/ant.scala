/*
The MIT License (MIT)
Copyright (c) 2016 Yang Bo & REA Group Ltd.
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

package com.sadhen.binding.magic

import com.thoughtworks.binding.Binding.BindingSeq
import com.thoughtworks.binding.{Binding, XmlExtractor}
import com.thoughtworks.binding.XmlExtractor._
import com.thoughtworks.Extractor._
import com.thoughtworks.sde.core.Preprocessor
import macrocompat.bundle
import org.scalajs.dom.raw._

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.collection.immutable.Queue
import scala.language.experimental.macros
import scala.reflect.NameTransformer
import scala.reflect.macros.whitebox

/**
  * Enable XML DOM literal for Binding.scala
  *
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
@compileTimeOnly("enable macro paradise to expand macro annotations")
class ant extends StaticAnnotation {
  def macroTransform(annottees: Any*): Any = macro ant.Macros.macroTransform
}

/**
  * @author 杨博 (Yang Bo) &lt;pop.atry@gmail.com&gt;
  */
object ant {
  /**
    * Render a binding node into `parent`
    */
  @inline
  def render(parent: Node, child: Binding[Node]): Unit = {
    Runtime.mount(parent, child).watch()
  }

  /**
    * Render a binding sequence of node into `parent`
    */
  @inline
  def render(parent: Node, children: BindingSeq[Node]): Unit = {
    Runtime.mount(parent, children).watch()
  }

  /**
    * Render a binding sequence of node into `parent`
    *
    * @usecase def render(parent: Node, children: Binding[BindingSeq[Node]]): Unit = ???
    **/
  @inline
  def render(parent: Node, children: Binding[BindingSeq[Node]], dummy: Unit = ()): Unit = {
    Runtime.mount(parent, children).watch()
  }

  @bundle
  final class Macros(context: whitebox.Context) extends Preprocessor(context) with XmlExtractor {

    import c.universe._

    def macroTransform(annottees: Tree*): Tree = {
      val transformer = new ComprehensionTransformer {

        private def transformXml(tree: Tree): (Queue[ValDef], Tree) = {
          tree match {
            case transformedWithValDefs.extract(queue, tree) =>
              (queue, tree)
            case transformed.extract(transformedTree) =>
              Queue.empty -> transformedTree
            case _ =>
              Queue.empty -> super.transform(tree)
          }
        }

        private def nodeSeq(children: Seq[Tree]): (Queue[ValDef], Tree) = {
          children match {
            case Seq() =>
              Queue.empty -> q"""_root_.com.thoughtworks.binding.Binding.Constants.empty"""
            case Seq(child) =>
              val (valDefs, transformedChild) = transformXml(child)
              valDefs -> atPos(child.pos) {
                q"""_root_.com.sadhen.binding.magic.Runtime.domBindingSeq($transformedChild)"""
              }
            case _ =>
              val transformedPairs = (for {
                child <- children
              } yield {
                val (valDefs, transformedChild) = transformXml(child)
                valDefs -> atPos(child.pos) {
                  q"""
                    _root_.com.thoughtworks.binding.Binding.apply {
                      _root_.com.sadhen.binding.magic.Runtime.domBindingSeq($transformedChild)
                    }
                  """
                }
              })(collection.breakOut(Queue.canBuildFrom))
              val (valDefs, transformedChildren) = transformedPairs.unzip
              valDefs.flatten -> q"""_root_.com.thoughtworks.binding.Binding.Constants(..$transformedChildren).flatMapBinding(_root_.scala.Predef.locally _)"""
          }
        }

        private def transformedWithValDefs: PartialFunction[Tree, (Queue[ValDef], Tree)] = {
          case tree @ NodeBuffer(children) =>
            nodeSeq(children)
          case tree @ Elem(tag, attributes, _, children) =>
            val idOption = findTextAttribute("local-id", attributes).orElse(findTextAttribute("id", attributes))
            val elementName = idOption match {
              case None     => TermName(c.freshName("htmlElement"))
              case Some(id) => TermName(NameTransformer.encode(id))
            }

            val attributeMountPoints = for {
              (key, value) <- attributes if {
                key match {
                  case UnprefixedName("local-id") => false
                  case _                          => true
                }
              }
            } yield {
              val attributeAccess = propertyAccess(key, q"$elementName")

              atPos(value.pos) {
                value match {
                  case EmptyAttribute() =>
                    q"""$attributeAccess = "" """
                  case Text(textLiteral) =>
                    q"$attributeAccess = $textLiteral"
                  case _ =>
                    val assignName = TermName(c.freshName("assignAttribute"))
                    val newValueName = TermName(c.freshName("newValue"))
                    q"""
                      _root_.com.thoughtworks.sde.core.MonadicFactory.Instructions.each[
                        _root_.com.thoughtworks.binding.Binding,
                        _root_.scala.Unit
                      ](
                        _root_.com.thoughtworks.binding.Binding.apply[_root_.scala.Unit]({
                          val $newValueName = ${transform(value)}
                          @_root_.scala.inline def $assignName() = {
                            if (_root_.com.sadhen.binding.magic.Runtime.notEqual($attributeAccess, $newValueName)) {
                              $attributeAccess = $newValueName
                            }
                          }
                          $assignName()
                        })
                      )
                    """
                }
              }
            }
            val (valDefs, transformedChild) = children match {
              case Seq() =>
                Queue.empty -> Nil
              case _ =>
                val (valDefs, transformedBuffer) = nodeSeq(children)
                valDefs -> List(atPos(tree.pos) {
                  q"""
                  _root_.com.thoughtworks.sde.core.MonadicFactory.Instructions.each[
                    _root_.com.thoughtworks.binding.Binding,
                    _root_.scala.Unit
                  ](
                    _root_.com.sadhen.binding.magic.Runtime.mount(
                      $elementName,
                      $transformedBuffer
                    )
                  )
                  """
                })
            }

            val tagAccess = propertyAccess(tag, q"_root_.com.sadhen.binding.magic.Runtime.TagsAndTags2")

            val elementDef = q"val $elementName = $tagAccess.render"
            idOption match {
              case None =>
                valDefs -> q"""
                  $elementDef
                  ..$transformedChild
                  ..$attributeMountPoints
                  $elementName
                """
              case Some(id) =>
                (valDefs.enqueue(elementDef)) -> q"""
                  ..$transformedChild
                  ..$attributeMountPoints
                  $elementName
                """
            }
        }

        private def findTextAttribute(unprefixedName: String,
                                      attributes: Seq[(XmlExtractor.QName, Tree)]): Option[String] = {
          attributes.collectFirst { case (UnprefixedName(`unprefixedName`), Text(text)) => text }
        }

        private def propertyAccess(xmlName: QName, objectAccess: RefTree): Select = {
          xmlName match {
            case UnprefixedName(localPart) =>
              q"$objectAccess.${TermName(NameTransformer.encode(localPart))}"
            case PrefixedName(prefix, localPart) =>
              localPart.split(':').foldLeft(q"$objectAccess.${TermName(NameTransformer.encode(prefix))}") {
                (prefixExpr, segmentName) =>
                  q"$prefixExpr.${TermName(NameTransformer.encode(segmentName))}"
              }
          }
        }

        private def transformed: PartialFunction[Tree, Tree] = {
          case Block(stats, expr) =>
            super.transform(Block(stats.flatMap {
              case transformedWithValDefs.extract((valDefs, transformedTree)) =>
                valDefs.enqueue(transformedTree)
              case stat =>
                Seq(stat)
            }, expr))
          case tree @ EntityRef(HtmlEntityName(unescapedCharacter)) =>
            atPos(tree.pos) {
              q"""$unescapedCharacter"""
            }
          case tree @ Comment(value) =>
            atPos(tree.pos) {
              q"""_root_.org.scalajs.dom.document.createComment($value)"""
            }
          case tree @ Text(value) =>
            atPos(tree.pos) {
              q"$value"
            }
        }

        override def transform(tree: Tree): Tree = {
          tree match {
            case transformedWithValDefs.extract((valDefs, transformedTree)) =>
              q"""
                ..$valDefs
                $transformedTree
              """
            case transformed.extract(transformedTree) =>
              transformedTree
            case _ =>
              super.transform(tree)
          }
        }
      }

      import transformer.transform
      //      def transform(tree: Tree): Tree = {
      //        val output = transformer.transform(tree)
      //        c.info(c.enclosingPosition, show(output), true)
      //        output
      //      }

      def autoImportAndTransform(body: Tree) = {
        q"""_root_.com.thoughtworks.binding.Binding.apply {
          import _root_.com.sadhen.binding.magic.AutoImports.{
            != => _,
            ## => _,
            == => _,
            eq => _,
            equals => _,
            getClass => _,
            hashCode => _,
            ne => _,
            notify => _,
            notifyAll => _,
            synchronized => _,
            toString => _,
            wait => _,
            _
          }
          workaroundUnusedImport()
          ${transform(body)}
        }"""
      }
      replaceDefBody(annottees, autoImportAndTransform)
    }

  }

}
