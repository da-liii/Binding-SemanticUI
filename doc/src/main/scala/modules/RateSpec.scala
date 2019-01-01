import scala.scalajs.js.annotation.JSExportTopLevel
import com.sadhen.binding.magic._
import com.sadhen.binding.component.tag._
import com.sadhen.binding.component.autoVar

/**
  * https://github.com/Semantic-Org/Semantic-UI-Docs/blob/master/server/documents/modules/rating.html.eco
  */
@JSExportTopLevel("RateSpec")
object RateSpec extends MainEntry {

  @ant
  override def main: Ant = {
    <div class="main ui container">
      <h1 class="ui header">
        Rating
        <div class="sub header">
          A rating indicates user interest in content 
        </div>
      </h1>
      <h2 class="ui dividing header">Types</h2>

      <h4 class="ui header">Rating</h4>
      <p>A basic rating </p>
      <Rate count={1} value={0}></Rate>

      <h4 class="ui header">Star</h4>
      <p>A rating can use a set of star icons</p>

      Rating<Rate count={4} value={3} star={true}></Rate>

      <h4 class="ui header">Heart</h4>
      <p>A rating can use a set of heart icons</p>
      <Rate count={3} value={1} heart={true}></Rate>

      <h2 class="ui dividing header">Variations</h2>

      <h4 class="ui header">Size</h4>
      <p>A rating can vary in size</p>
      <Rate count={4} value={3} star={true} size={"mini"}></Rate>
      <br></br>
      <Rate count={4} value={3} star={true} size={"tiny"}></Rate>
      <br></br>
      <Rate count={4} value={3} star={true} size={"small"}></Rate>
      <br></br>
      <Rate count={4} value={3} star={true}></Rate>
      <br></br>
      <Rate count={4} value={3} star={true} size={"large"}></Rate>
      <br></br>
      <Rate count={4} value={3} star={true} size={"huge"}></Rate>
      <br></br>
      <Rate count={4} value={3} star={true} size={"massive"}></Rate>
    </div>
  }
}
