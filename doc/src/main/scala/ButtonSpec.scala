import scala.scalajs.js.annotation.JSExportTopLevel
import com.sadhen.binding.magic.ant

import com.sadhen.binding.component.tag._

@JSExportTopLevel("ButtonSpec")
object ButtonSpec extends MainEntry {

  @ant
  override def body = {
    <div>
      <hr></hr>
      <Button></Button>
      <hr></hr>
    </div>
  }
}
