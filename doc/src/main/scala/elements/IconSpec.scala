import org.scalajs.dom.raw.Event
import scala.scalajs.js.annotation.JSExportTopLevel
import com.thoughtworks.binding.Binding.Var
import com.sadhen.binding.magic._
import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

@JSExportTopLevel("IconSpec")
object IconSpec extends MainEntry {
  val disabled: Var[Boolean] = Var(true)

  @ant
  override def main: Ant = {
    <div class="main ui container">
      <h1 class="ui header">
        Icon
        <div class="sub header">
          An icon is a glyph used to represent something else
        </div>
      </h1>

      <h2 class="ui dividing header">States</h2>

      <h4 class="ui header">Disabled</h4>
      <p>An icon can show that it is disabled</p>
      <Icon type="users" disabled={ disabled } />

      <h4 class="ui header">Loading</h4>
      <p>An icon can be used as a simple loader</p>
      <Icon type="spinner" loading={true} />
      <Icon type="notched" loading={true} />
      <Icon type="asterick" loading={true} />

      <h2 class="ui dividing header">Variations</h2>

      <h4 class="ui header">Fitted</h4>
      <p>An icon can be fitted, without any space to the left or right of it.</p>
      Tight spacing
      <i class="fitted help icon"></i>
      Tight spacing

      <h4 class="ui header">Size</h4>
      <p>An icon can vary in size</p>
      <Icon type="home" size="mini" />
      <Icon type="home" size="tiny" />
      <Icon type="home" size="small" />
      <br/>
      <Icon type="home" />
      <br />
      <Icon type="home" size="large" />
      <br />
      <Icon type="home" size="big" />
      <br />
      <Icon type="home" size="huge" />
      <br />
      <Icon type="home" size="massive" />

      <h4 class="ui header">Link</h4>
      <p>An icon can be formatted as a link</p>
      <i class="close link icon"></i>
      <i class="help link icon"></i>

      <h4 class="ui header">Flipped</h4>
      <p>An icon can be flipped</p>
      <i class="horizontally flipped cloud icon"></i>
      <i class="vertically flipped cloud icon"></i>

      <h4 class="ui header">Rotated</h4>
      <p>An icon can be rotated</p>
      <i class="clockwise rotated cloud icon"></i>
      <i class="counterclockwise rotated cloud icon"></i>


      <h4 class="ui header">Circular</h4>
      <p>An icon can be formatted to appear circular</p>
      <i class="circular users icon"></i>
      <i class="circular teal users icon"></i>
      <i class="circular inverted users icon"></i>
      <i class="circular inverted teal users icon"></i>

      <h4 class="ui header">Bordered</h4>
      <div class="ui ignored info message">
        In <code>0.x.x</code> bordered was formally known as <code>squared</code>
      </div>
      <p>An icon can be formatted to appear bordered</p>
      <i class="bordered users icon"></i>
      <i class="bordered teal users icon"></i>
      <i class="bordered inverted black users icon"></i>
      <i class="bordered inverted teal users icon"></i>

      <h4 class="ui header">Colored</h4>
      <p>An icon can be formatted with different colors</p>
      <Icon type="users" color="red" />
      <Icon type="users" color="orange" />
      <Icon type="users" color="yellow" />
      <Icon type="users" color="olive" />
      <Icon type="users" color="green" />
      <Icon type="users" color="teal" />
      <Icon type="users" color="blue" />
      <Icon type="users" color="violet" />
      <Icon type="users" color="purple" />
      <Icon type="users" color="pink" />
      <Icon type="users" color="brown" />
      <Icon type="users" color="grey" />
      <Icon type="users" color="black" />

      <h4 class="ui header">Inverted</h4>
      <p>An icon can have its colors inverted for contrast</p>
      <div class="ui inverted segment">
        <i class="inverted users icon"></i>
        <i class="inverted red users icon"></i>
        <i class="inverted orange users icon"></i>
        <i class="inverted yellow users icon"></i>
        <i class="inverted olive users icon"></i>
        <i class="inverted green users icon"></i>
        <i class="inverted teal users icon"></i>
        <i class="inverted blue users icon"></i>
        <i class="inverted violet users icon"></i>
        <i class="inverted purple users icon"></i>
        <i class="inverted pink users icon"></i>
        <i class="inverted brown users icon"></i>
        <i class="inverted grey users icon"></i>
      </div>

      <h2 class="ui dividing header">Groups</h2>

      <h4 class="ui header">Icons</h4>
      <p>Several icons can be used together as a group</p>
      <i class="huge icons">
        <i class="big circle outline icon"></i>
        <i class="user icon"></i>
      </i>
      <i class="huge icons">
        <i class="big red dont icon"></i>
        <i class="black user icon"></i>
      </i>
      <h4 class="ui header">Corner Icon</h4>
      <p>A group of icons can display a smaller corner icon</p>
      <i class="huge icons">
        <i class="puzzle icon"></i>
        <i class="corner add icon"></i>
      </i>
      <i class="huge icons">
        <i class="puzzle icon"></i>
        <i class="top left corner add icon"></i>
      </i>
      <i class="huge icons">
        <i class="puzzle icon"></i>
        <i class="top right corner add icon"></i>
      </i>
      <i class="huge icons">
        <i class="puzzle icon"></i>
        <i class="bottom left corner add icon"></i>
      </i>
      <i class="huge icons">
        <i class="puzzle icon"></i>
        <i class="bottom right corner add icon"></i>
      </i>
      <h2 class="ui header">
        <i class="large icons">
          <i class="twitter icon"></i>
          <i class="inverted corner add icon"></i>
        </i>
        Add on Twitter
      </h2>
    </div>
  }
}
