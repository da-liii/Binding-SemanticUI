package com.sadhen.binding.magic

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding._

import org.scalajs.dom.document
import org.scalajs.dom.raw._

import scalatags.JsDom
import scalatags.jsdom
import scalatags.JsDom.TypedTag
import scalatags.generic.Namespace

import scala.annotation.tailrec
import scala.collection.GenSeq

/**
  * Internal helpers for `@ant` annotation
  *
  * @note Do not use methods and classes in this object.
  */
object Runtime extends LowPriorityRuntime {
  @inline
  @tailrec
  private def removeAll(parent: Node): Unit = {
    val firstChild = parent.firstChild
    if (firstChild != null) {
      parent.removeChild(firstChild)
      removeAll(parent)
    }
  }

  @inline
  def mount(parent: Node, childrenBinding: BindingSeq[Node]): NodeSeqMountPoint = {
    new NodeSeqMountPoint(parent, childrenBinding)
  }

  @inline
  def mount(parent: Node, childBinding: Binding[BindingSeq[Node]], dummy: Unit = ()): NodeSeqMountPoint = {
    new NodeSeqMountPoint(parent, childBinding, dummy)
  }

  @inline
  def mount(parent: Node, childBinding: Binding[Node]): NodeMountPoint = {
    new NodeMountPoint(parent, childBinding)
  }

  final class NodeMountPoint private[Runtime] (parent: Node, childBinding: Binding[Node])
    extends SingleMountPoint[Node](childBinding) {
    protected def set(child: Node): Unit = {
      removeAll(parent)
      if (child.parentNode != null) {
        throw new IllegalStateException(raw"""Cannot insert ${child.nodeName} twice!""")
      }
      parent.appendChild(child)
    }
  }

  final class NodeSeqMountPoint(parent: Node, childrenBinding: BindingSeq[Node])
    extends MultiMountPoint[Node](childrenBinding) {

    @inline
    def this(parent: Node, childBinding: Binding[BindingSeq[Node]], dummy: Unit = ()) = {
      this(parent, Constants(childBinding).flatMapBinding(identity))
    }

    override protected def set(children: Seq[Node]): Unit = {
      removeAll(parent)
      for (child <- children) {
        if (child.parentNode != null) {
          throw new IllegalStateException(raw"""Cannot insert ${child.nodeName} twice!""")
        }
        parent.appendChild(child)
      }
    }

    override protected def splice(from: Int, that: GenSeq[Node], replaced: Int): Unit = {
      @inline
      @tailrec
      def removeChildren(child: Node, n: Int): Node = {
        if (n == 0) {
          child
        } else {
          val nextSibling = child.nextSibling
          parent.removeChild(child)
          removeChildren(nextSibling, n - 1)
        }
      }

      val child = removeChildren(parent.childNodes(from), replaced)
      if (child == null) {
        for (newChild <- that) {
          if (newChild.parentNode != null) {
            throw new IllegalStateException(raw"""Cannot insert a ${newChild.nodeName} element twice!""")
          }
          parent.appendChild(newChild)
        }
      } else {
        for (newChild <- that) {
          if (newChild.parentNode != null) {
            throw new IllegalStateException(raw"""Cannot insert a ${newChild.nodeName} element twice!""")
          }
          parent.insertBefore(newChild, child)
        }
      }
    }

  }

  object TagsAndTags2 extends JsDom.Cap with jsdom.Tags with jsdom.Tags2 {

    import scala.language.dynamics

    final class DynamicDataTag private[TagsAndTags2] ()
      extends TypedTag[HTMLElement]("data", Nil, false, Namespace.htmlNamespaceConfig)
        with Dynamic {
      final def selectDynamic(tagName: String): ConcreteHtmlTag[Element] = {
        TagsAndTags2.tag(tagName)
      }
    }

    override lazy val data = new DynamicDataTag()

  }

  @inline
  def domBindingSeq(bindingSeq: BindingSeq[Node]) = bindingSeq

  @inline
  def domBindingSeq(seq: Seq[Node]) = Constants(seq: _*)

  @inline
  def domBindingSeq(node: Node) = Constants(node)

  @inline
  def domBindingSeq(text: String) = Constants(document.createTextNode(text))

  @inline
  def domBindingSeq(optionNode: Option[Node]) = Constants(optionNode.toSeq: _*)

  @inline
  def notEqual[A](left: A, right: A) = left != right
}
