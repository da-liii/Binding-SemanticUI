package com.sadhen.binding.component.datadisplay

import com.sadhen.binding.component.ComponentBuilder
import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.raw.Node

import scala.scalajs.js

/**
  * Created by rendong on 17/1/25.
  */
trait Column {
  val title: String
  val dataIndex: String
  val key: String
  @dom
  def render(data: js.Dynamic): Binding[Node] =
    <td>{ data.selectDynamic(dataIndex).toString }</td>
}

case class TableBuilder() extends ComponentBuilder {
  var dataSource: Var[Array[js.Dynamic]] = Var(Array.empty)
  var columns: Var[Array[Column]] = Var(Array.empty)

  def render = this

  @dom
  override def build = {
    <table class="ui table">
      <thead>
        <tr>
        { for (column <- Vars(columns.bind: _*)) yield <th>{ column.title }</th>}
        </tr>
      </thead>
      <tbody>
        { for (data <- Vars(dataSource.bind: _*)) yield
          <tr>
            { for (column <- Vars(columns.bind: _*)) yield column.render(data).bind }
          </tr>
        }
      </tbody>
    </table>
  }
}
