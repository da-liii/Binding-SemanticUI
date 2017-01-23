package com.sadhen.binding.component

import com.thoughtworks.binding.Binding
import org.scalajs.dom.raw.Node

/**
  * Created by rendong on 17/1/23.
  */
trait ComponentBuilder {
  def build: Binding[Node]
}
