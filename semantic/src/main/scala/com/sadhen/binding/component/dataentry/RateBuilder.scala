package com.sadhen.binding.component.dataentry

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.raw.Node

case class RateBuilder() extends ComponentBuilder {
  var count: Var[Int] = Var(5)
  var value: Var[Int] = Var(0)
  var size: Var[String] = Var("")
  var star: Var[Boolean] = Var(false)
  var heart: Var[Boolean] = Var(false)

  val constAttr = "ui rating"

  def fStar(star: Boolean): String =
    if (star) "star"
    else ""

  def fHeart(heart: Boolean): String =
    if (heart) "heart"
    else ""

  def render = this

  @dom
  override def build: Binding[Node] = {
    <div class={ List(fStar(star.bind), fHeart(heart.bind), constAttr).mkString(" ") }
         data:data-max-rating={ count.bind.toString }
         data:data-rating={ value.bind.toString }>
    </div>
  }
}
