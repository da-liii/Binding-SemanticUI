import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import com.sadhen.binding.magic._

import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("ProgressSpec")
object ProgressSpec extends MainEntry {

  @ant
  override def main: Ant = {
    <div>
      <hr></hr>
      <Progress value={5} total={100}></Progress>
      <hr></hr>
    </div>
  }
}
