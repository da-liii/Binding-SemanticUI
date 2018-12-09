package com.sadhen.binding.component.dataentry

import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.{BindingSeq, Constants, Var}
import org.scalajs.dom.raw.Node
import com.sadhen.binding.component.ComponentBuilder
import com.sadhen.binding.component.tag.Icon
import com.sadhen.binding.component.autoVar
import com.sadhen.binding.util.BindingRange


class RateBuilder extends ComponentBuilder[RateBuilder] {
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

  @dom
  private def iconGen(ind: Int): Binding[Node] = {
    // TODO: The dummy div pair should be removed later
    <div>
      <Icon active={ind < value.bind}></Icon>
    </div>
  }

  @dom
  override def build: Binding[Node] = {
    <div class={ List(constAttrStart, fStar(star.bind), fHeart(heart.bind), constAttrEnd).filter(_.nonEmpty).mkString(" ") }
         data:data-max-rating={ count.bind.toString }
         data:data-rating={ value.bind.toString }>
      { BindingRange(count.bind).map(iconGen(_).bind) }
    </div>
  }
}
