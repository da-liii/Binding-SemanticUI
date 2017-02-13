# Binding-SemanticUI [![Scala.js](http://scala-js.org/assets/badges/scalajs-0.6.13.svg)](http://scala-js.org)[![Latest](https://index.scala-lang.org/sadhen/binding-semanticui/semantic-ui/latest.svg)](https://index.scala-lang.org/sadhen/binding-semanticui)

Available Components:

| Component | Status |
|-----------|--------|
| Pagination | basic |
| Table      | basic |

## Example
``` scala
import com.thoughtworks.binding.{Binding, dom}

import scala.scalajs.js
import org.scalajs.dom.document
import com.sadhen.binding.component.tag.Table
import com.sadhen.binding.component.datadisplay.Column
import com.sadhen.binding.component._
import org.scalajs.dom.raw.Node

object ExamplePage extends js.JSApp {
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
  def render = {
    // Simply assign the dataSource and columns, you would get a Table with
    // the simplest Pagination
    <Table dataSource={ dataSource } columns={ columns }></Table>
  }

  override def main() = {
    dom.render(document.body, render)
  }
}
```
