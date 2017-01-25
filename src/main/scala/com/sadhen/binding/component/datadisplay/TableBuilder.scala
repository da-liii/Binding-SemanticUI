package com.sadhen.binding.component.datadisplay

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.dom

/**
  * Created by rendong on 17/1/25.
  */
case class TableBuilder() extends ComponentBuilder {
  def render = this

  @dom
  override def build = {
    <div>
    </div>
  }
}
