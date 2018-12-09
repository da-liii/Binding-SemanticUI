package com.sadhen.binding.component.feedback

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.{Binding, dom}
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.raw.Node

class ProgressBuilder extends ComponentBuilder {
  var value: Var[Int] = Var(0)
  var total: Var[Int] = Var(100)

  def render = this

  @dom
  override def build: Binding[Node] = {
    <div class="ui progress" data:data-value={ value.bind.toString } data:data-total={ total.bind.toString }>
      <div class="bar">
        <div class="progress"></div>
      </div>
    </div>
  }
}
