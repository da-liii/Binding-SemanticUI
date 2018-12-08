import scala.scalajs.js.annotation.JSExportTopLevel
import com.thoughtworks.binding.dom

import com.sadhen.binding.component.tag._

@JSExportTopLevel("ButtonSpec")
object ButtonSpec extends MainEntry {

  @dom
  override def body = {
    <div>
      <hr></hr>
      <Button></Button>
      <hr></hr>
    </div>
  }
}
