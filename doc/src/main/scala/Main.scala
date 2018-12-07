import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import com.sadhen.binding.component.tag._
import com.thoughtworks.binding.Binding.Var

import scala.scalajs.js.annotation.JSExport

@JSExport
object Main {
  @dom
  def icon = {
    <div>
      <hr></hr>
      <Icon type={ Var("archive") }></Icon>
      <hr></hr>
    </div>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, icon)
  }
}
