import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

import scala.scalajs.js
import scala.scalajs.js.annotation.{JSExport, JSExportTopLevel}

@JSExportTopLevel("RateSpec")
object RateSpec {
  @dom
  def rating = {
    <div>
      <hr></hr>
      <Rate count={1}></Rate>
      <hr></hr>
      <Rate count={4} value={3} star={true}></Rate>
      <hr></hr>
    </div>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, rating)
  }
}
