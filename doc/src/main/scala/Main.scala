import com.thoughtworks.binding.Binding.Var
import com.thoughtworks.binding.dom
import org.scalajs.dom.document
import org.scalajs.dom.raw.Event

import scala.scalajs.js.annotation.JSExport

@JSExport
object Main {
  @dom
  def spinner(i: Var[Int]) = {
    <div>
      <button onclick={ event: Event => i.value -= 1 }>-</button>
      { i.bind.toString }
      <button onclick={ event: Event => i.value += 1 }>+</button>
    </div>
  }

  @dom
  def render = {
    val i = Var(0)
    <div>
      { spinner(i).bind }
      The current value of the spinner is { i.bind.toString }
    </div>
  }

  @JSExport
  def main(): Unit = {
    dom.render(document.body, render)
  }
}
