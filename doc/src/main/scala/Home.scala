import scala.scalajs.js.annotation.JSExportTopLevel
import com.sadhen.binding.magic._

@JSExportTopLevel("Home")
object Home extends MainEntry {

  @ant
  override def main: Ant = {
    <div>
      <div class="pusher">
        <div class="ui inverted vertical masthead center aligned segment">
          <div class="ui container">
            <div class="ui large secondary inverted pointing menu">
              <a class="toc item">
                <i class="sidebar icon"></i>
              </a>
            </div>
          </div>

          <div class="ui text container">
            <h1 class="ui inverted header">
              Binding Semantic
            </h1>
            <h2>Typed Components using Binding.scala and Semantic UI</h2>
            <div class="ui huge primary button">Get Started  <a href="introduction/start/"><i class="right arrow icon"></i></a></div>
          </div>
        </div>
      </div>
    </div>
  }
}

