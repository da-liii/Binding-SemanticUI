package com.sadhen.binding

import com.sadhen.binding.component.impl.ComponentBuilder
import com.thoughtworks.binding.Binding.{BindingSeq, Constants}

import scala.language.implicitConversions
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.raw.Node

/**
  * Created by rendong on 17/1/23.
  */
package object component {
  implicit def autoBinding[A](a: A): Binding[A] = Binding(a)


  implicit def toHtml(x: ComponentBuilder): BindingSeq[Node] = {
    Constants(x.build).mapBinding(identity)
  }
}

