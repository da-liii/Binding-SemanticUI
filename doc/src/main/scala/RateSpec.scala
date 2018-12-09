import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import com.sadhen.binding.magic.ant

import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("RateSpec")
object RateSpec extends MainEntry {

  @ant
  override def body = {
    <div>
      <hr></hr>
      <Rate></Rate>
      <hr></hr>
      <Rate count={4} value={3} star={true}></Rate>
      <hr></hr>
    </div>
  }
}
