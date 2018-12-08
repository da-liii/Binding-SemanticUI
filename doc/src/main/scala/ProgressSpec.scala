import com.thoughtworks.binding.dom

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import org.scalajs.dom.document
import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("ProgressSpec")
object ProgressSpec {

  @dom
  def body = {
    <div>
      <hr></hr>
      <Progress value={5} total={100}></Progress>
      <hr></hr>
    </div>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, body)
  }
}
