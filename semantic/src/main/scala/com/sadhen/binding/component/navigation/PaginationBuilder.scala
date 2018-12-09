package com.sadhen.binding.component.navigation

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.dom
import org.scalajs.dom.raw.Event

/**
  * Created by rendong on 17/1/23.
  */
class PaginationBuilder extends ComponentBuilder {
  var defaultCurrent: Var[Int] = Var(1)
  var total: Var[Int] = Var(1)
  var simple: Var[Boolean] = Var(false)

  def render = this

  @dom
  override def build = {
    <div>
      <button
        class="ui small basic icon button"
        style="box-shadow:0px 0px 0px 0px"
        onclick={ event: Event =>
          defaultCurrent := (if (defaultCurrent.get <= 1) defaultCurrent.get else defaultCurrent.get - 1)
        }>
        <i class="left chevron icon"></i>
      </button>
      <div class="ui small input" style="padding: 5px 0px 5px 0px;width: 26px;">
        <input type="text"
               value={ defaultCurrent.bind.toString }
               style="padding: 0px 0px 0px 0px; text-align: center;"/>
      </div>
      <span>/</span>
      <span>{ s"${total.bind}" }</span>
      <button
        class="ui small basic icon button"
        style="box-shadow:0px 0px 0px 0px"
        onclick={ event: Event =>
          defaultCurrent := (if (defaultCurrent.get >= total.get) defaultCurrent.get else defaultCurrent.get + 1)
        }>
        <i class="right chevron icon"></i>
      </button>
    </div>
  }
}
