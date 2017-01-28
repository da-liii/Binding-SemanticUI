package com.sadhen.binding.component.datadisplay

import com.sadhen.binding.component._
import com.sadhen.binding.component.tag.Pagination

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
  def render(record: js.Dynamic): Binding[Node] =
    <td>{ record.selectDynamic(dataIndex).toString }</td>
}

case class TableBuilder() extends ComponentBuilder {
  var dataSource: Var[Array[js.Dynamic]] = Var(Array.empty)
  var columns: Var[Array[Column]] = Var(Array.empty)

  def render = this

  @dom
  override def build = {
    val pageSize = 10
    val currentPage = Var(1)
    val total = Var((dataSource.get.size - 1)/pageSize + 1)

    <table class="ui table">
      <thead>
        <tr>
        { for (column <- Vars(columns.bind: _*)) yield <th>{ column.title }</th>}
        </tr>
      </thead>
      <tbody>
        { for (record <- Vars(dataSource.bind.slice(pageSize*(currentPage.bind-1), pageSize*currentPage.bind): _*)) yield
          <tr>
            { for (column <- Vars(columns.bind: _*)) yield column.render(record).bind }
          </tr>
        }
      </tbody>
      <tfoot>
        <tr>
          <th colSpan={ columns.bind.size }>
            <div class="ui right floated pagination menu">
              <Pagination simple={ true }
                          defaultCurrent={ currentPage }
                          total={ total }
              ></Pagination>
            </div>
          </th>
        </tr>
      </tfoot>
    </table>
  }
}
