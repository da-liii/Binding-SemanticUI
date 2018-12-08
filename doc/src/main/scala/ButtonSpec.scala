import com.thoughtworks.binding.dom
import org.scalajs.dom.document

import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}
import com.sadhen.binding.component.tag._

@JSExportTopLevel("ButtonSpec")
object ButtonSpec {

  @dom
  def body = {
    <div>
      <hr></hr>
      <Button></Button>
      <hr></hr>
    </div>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, body)
  }

}
