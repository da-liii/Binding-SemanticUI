package com.sadhen.binding.component.general

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.raw.Node

case class IconBuilder() extends ComponentBuilder {
  var `type`: Var[String] = Var("")

  def render = this

  @dom
  override def build: Binding[Node] = {
    <i class={`type`.bind.toString + " icon"}></i>
  }
}
