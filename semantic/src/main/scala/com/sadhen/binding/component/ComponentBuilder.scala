package com.sadhen.binding.component

import com.thoughtworks.binding.Binding
import org.scalajs.dom.raw.Node

/**
  * Created by rendong on 17/1/23.
  */
trait ComponentBuilder[T] { self: T =>
  def build: Binding[Node]

  def render: T = self
}
