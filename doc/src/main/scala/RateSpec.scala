import scala.scalajs.js.annotation.JSExportTopLevel
import org.scalajs.dom.document
import com.thoughtworks.binding.dom

import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("RateSpec")
object RateSpec extends MainEntry {

  @dom
  override def body = {
    <div>
      <hr></hr>
      <Rate count={1}></Rate>
      <hr></hr>
      <Rate count={4} value={3} star={true}></Rate>
      <hr></hr>
    </div>
  }
}
