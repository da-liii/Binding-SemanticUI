package com.sadhen.binding.component.dataentry

import org.scalajs.dom.raw.{Event, Node}
import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.Var

import com.sadhen.binding.component.ComponentBuilder
import com.sadhen.binding.component.tag.Icon
import com.sadhen.binding.component.autoVar
import com.sadhen.binding.magic.ant
import com.sadhen.binding.util.BindingRange

/**
  * Ref:
  *   - [[https://semantic-ui.com/modules/rating.html]]
  *   - [[https://ant.design/components/rate/]]
  */
class RateBuilder extends ComponentBuilder[RateBuilder] {
  /** star count */
  var count: Var[Int] = Var(5)
  /** current value */
  var value: Var[Int] = Var(0)
  var size: Var[String] = Var("")
  /** use the star icon */
  var star: Var[Boolean] = Var(false)
  /** use the heart icon */
  var heart: Var[Boolean] = Var(false)
  var onChange: Var[Int => Unit] = Var(v => {})

  val constAttrStart = "ui"
  val constAttrEnd = "rating"

  private def fStar(star: Boolean): String =
    if (star) "star"
    else ""

  private def fHeart(heart: Boolean): String =
    if (heart) "heart"
    else ""

  @ant
  private def iconGen(ind: Int): Binding[Node] = {
    val current = ind + 1
    val active: Var[Boolean] = Var(current <= value.bind)
    // TODO: The dummy div pair should be removed later
    <div>
      <Icon active={ active }
            onclick={ event: Event =>
              // change the current value to the clicked one
              value.value = current
              // invoke the customized onChange event
              onChange.value(ind)
            } />
    </div>
  }

  @ant
  override def build: Binding[Node] = {
    <div class={
         List(constAttrStart, fStar(star.bind), fHeart(heart.bind), size.bind, constAttrEnd)
           .filter(_.nonEmpty).mkString(" ")
         }
         data:data-max-rating={ count.bind.toString }
         data:data-rating={ value.bind.toString }>
      { BindingRange(count.bind).map(iconGen(_).bind) }
    </div>
  }
}
