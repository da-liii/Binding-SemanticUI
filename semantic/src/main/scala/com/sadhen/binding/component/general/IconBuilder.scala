package com.sadhen.binding.component.general

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.raw.Node

/**
  * Ref:
  *   - [[https://semantic-ui.com/elements/icon.html]]
  *   - [[https://ant.design/components/icon/]]
  */
case class IconBuilder() extends ComponentBuilder {
  /** Type(name) of an icon, which determines the shape of an icon */
  var `type`: Var[String] = Var("")
  /** State of an icon, enabled by default */
  var disabled: Var[Boolean] = Var(false)
  /** State of an icon, static(not loading) by default */
  var loading: Var[Boolean] = Var(false)
  /** Color of an icon */
  var color: Var[String] = Var("")

  private val constAttr = "icon"

  def render = this

  private def fDisabled(disabled: Boolean): String = {
    if (disabled) "disabled"
    else ""
  }

  private def fLoading(loading: Boolean): String = {
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
        constAttr
      ).mkString(" ")
    }>
    </i>
  }
}
