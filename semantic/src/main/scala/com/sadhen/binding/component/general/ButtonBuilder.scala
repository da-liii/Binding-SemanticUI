package com.sadhen.binding.component.general

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.raw.Node

case class ButtonBuilder() extends ComponentBuilder {

  def render = this

  val constAttrStart = "ui"
  val constAttrEnd = "button"

  @dom
  override def build: Binding[Node] = {
    <button class="ui button">
      Follow
    </button>
  }

}
