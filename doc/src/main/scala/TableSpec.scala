import com.thoughtworks.binding.{Binding, dom}

import scala.scalajs.js
import org.scalajs.dom.document
import com.sadhen.binding.component.tag.Table
import com.sadhen.binding.component.datadisplay.Column
import com.sadhen.binding.component._
import org.scalajs.dom.raw.Node

import scala.scalajs.js.annotation.JSExportTopLevel

@JSExportTopLevel("TableSpec")
object TableSpec extends MainEntry {
  val dataSource: Array[js.Dynamic] = Array(
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "Title", age=23),
    js.Dynamic.literal(title = "World", age=24)
  )

  // Define the Columns
  // By default, it shows the data according to dataIndex
  // However, you may override the render method for customization
  val columns: Array[Column] = Array(
    new Column {
      val title = "Title"
      val dataIndex = "title"
    },
    new Column {
      val title = "Age"
      val dataIndex = "age"
      @dom
      override def render(record: js.Dynamic): Binding[Node] = {
        <td>{ record.selectDynamic(dataIndex).toString + " years old" }</td>
      }
    }
  )

  @dom
  def body = {
    // Simply assign the dataSource and columns, you would get a Table with
    // the simplest Pagination
    <div><Table dataSource={ dataSource } columns={ columns }></Table></div>
  }
}