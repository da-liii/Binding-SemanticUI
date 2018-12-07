package com.sadhen.binding.component.general

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.raw.Node

case class IconBuilder() extends ComponentBuilder {
  var `type`: Var[String] = Var("")
  var disabled: Var[Boolean] = Var(false)
  var loading: Var[Boolean] = Var(false)
  var color: Var[String] = Var("")

  def render = this

  def fDisabled(disabled: Boolean): String = {
    if (disabled) "disabled"
    else ""
  }

  def fLoading(loading: Boolean): String = {
    if (loading) "loading"
    else ""
  }

  @dom
  override def build: Binding[Node] = {
    <i class={
      List(
        color.bind,
        `type`.bind,
        fLoading(loading.bind),
        fDisabled(disabled.bind),
        "icon"
      ).mkString(" ")
    }>
    </i>
  }
}
