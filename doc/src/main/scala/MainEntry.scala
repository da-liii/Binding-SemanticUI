import scala.scalajs.js.annotation.JSExport
import org.scalajs.dom.document
import org.scalajs.dom.raw.Node

import com.thoughtworks.binding.Binding.BindingSeq
import com.thoughtworks.binding.{Binding, dom}


trait MainEntry {
  def body: Binding[Node]

  @JSExport
  def main(): Unit = {
    dom.render(document.body, body)
  }
}
