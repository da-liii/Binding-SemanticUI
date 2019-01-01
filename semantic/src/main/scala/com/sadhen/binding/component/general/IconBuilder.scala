package com.sadhen.binding.component.general

import org.scalajs.dom.raw.{Event, HTMLElement, Node}
import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.Var
import com.sadhen.binding.component.ComponentBuilder
import com.sadhen.binding.magic.ant

/**
  * Ref:
  *   - [[https://semantic-ui.com/elements/icon.html]]
  *   - [[https://ant.design/components/icon/]]
  */
class IconBuilder extends ComponentBuilder[IconBuilder] {
  /** Type(name) of an icon, which determines the shape of an icon */
  var `type`: Var[String] = Var("")
  /** Color of an icon */
  var color: Var[String] = Var("")
  /** Size of an icon */
  var size: Var[String] = Var("")
  /** State of an icon, enabled by default */
  var disabled: Var[Boolean] = Var(false)
  /** State of an icon, static(not loading) by default */
  var loading: Var[Boolean] = Var(false)
  /** State of an icon, used together with Rate */
  var active: Var[Boolean] = Var(false)
  var onclick: Var[Event => Unit] = Var { event => }

  private val constAttr = "icon"

  private def fDisabled(disabled: Boolean): String = {
    if (disabled) "disabled"
    else ""
  }

  private def fLoading(loading: Boolean): String = {
    if (loading) "loading"
    else ""
  }

  private def fActive(active: Boolean): String = {
    if (active) "active"
    else ""
  }

  @ant
  override def build: Binding[Node] = {
    <i class={
      List(
        color.bind,
        `type`.bind,
        size.bind,
        fActive(active.bind),
        fLoading(loading.bind),
        fDisabled(disabled.bind),
        constAttr
      ).filter(_.nonEmpty).mkString(" ")
    }
    onclick={ onclick.bind }
    />
  }
}
