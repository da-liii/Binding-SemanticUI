package com.sadhen.binding.component.dataentry

import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.{Constants, Var}
import org.scalajs.dom.raw.Node

import com.sadhen.binding.component.ComponentBuilder
import com.sadhen.binding.component.tag.Icon
import com.sadhen.binding.component.autoVar


class RateBuilder extends ComponentBuilder {
  var count: Var[Int] = Var(5)
  var value: Var[Int] = Var(0)
  var size: Var[String] = Var("")
  var star: Var[Boolean] = Var(false)
  var heart: Var[Boolean] = Var(false)

  val constAttrStart = "ui"
  val constAttrEnd = "rating"

  private def fStar(star: Boolean): String =
    if (star) "star"
    else ""

  private def fHeart(heart: Boolean): String =
    if (heart) "heart"
    else ""

  private def fActive(active: Boolean): String =
    if (active) "active"
    else ""

  def render = this

  @dom
  override def build: Binding[Node] = {
    <div class={ List(constAttrStart, fStar(star.bind), fHeart(heart.bind), constAttrEnd).filter(_.nonEmpty).mkString(" ") }
         data:data-max-rating={ count.bind.toString }
         data:data-rating={ value.bind.toString }>
      {
        Constants((0 until count.bind): _*).map( ind =>
          <div>
            <Icon active={ind < value.bind}></Icon>
          </div>

        )
      }
    </div>
  }
}
