import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.document

import com.sadhen.binding.magic._


trait MainEntry {
  def main: Ant

  @JSExport
  def jsGate(): Unit = {
    ant.render(document.body, main)
  }
}
