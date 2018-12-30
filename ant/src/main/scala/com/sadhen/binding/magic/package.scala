package com.sadhen.binding

import scala.annotation.{StaticAnnotation, compileTimeOnly}
import scala.language.experimental.macros
import org.scalajs.dom.raw.Node

import com.thoughtworks.binding.Binding.BindingSeq
import com.thoughtworks.binding.Binding


package object magic {
  type Ant = Binding[Node]

  @compileTimeOnly("enable macro paradise to expand macro annotations")
  class ant extends StaticAnnotation {
    def macroTransform(annottees: Any*): Any = macro Macros.macroTransform
  }

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

  }

}
