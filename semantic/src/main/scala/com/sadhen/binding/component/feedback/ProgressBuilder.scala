package com.sadhen.binding.component.feedback

import com.thoughtworks.binding.Binding
import com.thoughtworks.binding.Binding.Var
import org.scalajs.dom.raw.Node

import com.sadhen.binding.component.ComponentBuilder
import com.sadhen.binding.magic.ant

class ProgressBuilder extends ComponentBuilder[ProgressBuilder] {
  var value: Var[Int] = Var(0)
  var total: Var[Int] = Var(100)

  @ant
  override def build: Binding[Node] = {
    <div class="ui progress" data:data-value={ value.bind.toString } data:data-total={ total.bind.toString }>
      <div class="bar">
        <div class="progress"></div>
      </div>
    </div>
  }
}
