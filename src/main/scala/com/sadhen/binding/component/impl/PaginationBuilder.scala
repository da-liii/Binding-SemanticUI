package com.sadhen.binding.component.impl

import com.thoughtworks.binding.{Binding, dom}

/**
  * Created by rendong on 17/1/23.
  */
case class PaginationBuilder() extends ComponentBuilder {
  var defaultCurrent: Binding[Int] = _
  var total: Binding[Int] = _
  var simple: Binding[Boolean] = Binding(false)

  def render = this

  @dom
  def build = {
    <div>
      <h1>{ if (simple.bind) "Simple" else "Complicated" }</h1>
    </div>
  }
}
