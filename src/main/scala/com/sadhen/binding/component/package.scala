package com.sadhen.binding

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.Binding.{BindingSeq, Constants, Var}

import scala.language.implicitConversions
import org.scalajs.dom.raw.Node

/**
  * Created by rendong on 17/1/23.
  */
package object component {
  implicit def autoVar[A](a: A): Var[A] = Var(a)

  implicit def toHtml(x: ComponentBuilder): BindingSeq[Node] = {
    Constants(x.build).mapBinding(identity)
  }
}

