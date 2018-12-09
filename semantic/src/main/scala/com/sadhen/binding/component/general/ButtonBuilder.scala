package com.sadhen.binding.component.general

import com.sadhen.binding.component.ComponentBuilder
import com.sadhen.binding.magic.ant
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.raw.Node

class ButtonBuilder extends ComponentBuilder[ButtonBuilder] {

  val constAttrStart = "ui"
  val constAttrEnd = "button"

  @ant
  override def build: Binding[Node] = {
    <button class="ui button">
      Follow
    </button>
  }

}
