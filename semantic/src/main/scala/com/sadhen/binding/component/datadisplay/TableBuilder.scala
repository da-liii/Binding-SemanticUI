package com.sadhen.binding.component.datadisplay

import com.sadhen.binding.component._
import com.thoughtworks.binding.Binding.{Var, Vars}
import com.thoughtworks.binding.{Binding, dom}
import org.scalajs.dom.raw.{Event, Node}

import scala.scalajs.js


/**
  * Created by rendong on 17/1/25.
  */
trait Column {
  val title: String
  val dataIndex: String
  @dom
  def render(record: js.Dynamic): Binding[Node] =
    <td>{ record.selectDynamic(dataIndex).toString }</td>
}

class TableBuilder extends ComponentBuilder {
  var dataSource: Var[Array[js.Dynamic]] = Var(Array.empty)
  var columns: Var[Array[Column]] = Var(Array.empty)

  def render = this

  @dom
  override def build = {
    val pageSize = 10
    val defaultCurrent = Var(1)

    <table class="ui celled table">
      <thead>
        <tr>
        { for (column <- Vars(columns.bind: _*)) yield <th>{ column.title }</th>}
        </tr>
      </thead>
      <tbody>
        { for (record <- Vars(dataSource.bind.slice(pageSize*(defaultCurrent.bind-1), pageSize*defaultCurrent.bind): _*)) yield
          <tr>
            { for (column <- Vars(columns.bind: _*)) yield column.render(record).bind }
          </tr>
        }
      </tbody>
      <tfoot>
        <tr>
          <th colSpan={ columns.bind.size }>
            <div class="ui right floated pagination menu">
              <div>
                <button class="ui small basic icon button"
                        style="box-shadow:0px 0px 0px 0px"
                        onclick={ event: Event =>
                          defaultCurrent := (if (defaultCurrent.get <= 1) defaultCurrent.get else defaultCurrent.get - 1)
                        }
                >
                  <i class="left chevron icon"></i>
                </button>
                <div class="ui small input" style="padding: 5px 0px 5px 0px;width: 26px;">
                  <input type="text"
                         value={ defaultCurrent.bind.toString }
                         style="padding: 0px 0px 0px 0px; text-align: center;"/>
                </div>
                <span>/</span>
                <span>{ s"${(dataSource.bind.size - 1)/pageSize + 1}" }</span>
                <button class="ui small basic icon button"
                        style="box-shadow:0px 0px 0px 0px"
                        onclick={ event: Event =>
                          defaultCurrent := (if (defaultCurrent.get >= (dataSource.get.size - 1)/pageSize + 1) defaultCurrent.get else defaultCurrent.get + 1)
                        }
                >
                  <i class="right chevron icon"></i>
                </button>
              </div>
            </div>
          </th>
        </tr>
      </tfoot>
    </table>
  }
}
