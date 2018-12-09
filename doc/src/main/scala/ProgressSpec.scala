import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import com.sadhen.binding.magic.ant

import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("ProgressSpec")
object ProgressSpec extends MainEntry {

  @ant
  override def body = {
    <div>
      <hr></hr>
      <Progress value={5} total={100}></Progress>
      <hr></hr>
    </div>
  }
}
