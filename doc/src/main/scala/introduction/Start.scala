import scala.scalajs.js.annotation.JSExportTopLevel

import com.sadhen.binding.magic._
import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("Start")
object Start extends MainEntry {
  @ant
  override def main: Ant = {
    <div>
      <table class="ui celled table">
        <thead>
          <tr>
            <th>Components</th>
            <th>Progress</th>
            <th>Version</th>
          </tr>
        </thead>
        <tbody>
          <tr>
            <td><a href="/elements/icon/">Icon</a></td>
            <td><Progress value={60} total={100}></Progress></td>
            <td>v0.1.0</td>
          </tr>
          <tr>
            <td><a href="/modules/rate/">Rate</a></td>
            <td><Progress value={90} total={100}></Progress></td>
            <td>v0.1.0</td>
          </tr>
          <tr>
            <td><a href="/modules/progress/">Progress</a></td>
            <td><Progress value={20} total={100}></Progress></td>
            <td>v0.1.0</td>
          </tr>
        </tbody>
      </table>
    </div>
  }
}
