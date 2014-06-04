import cucumber.api.scala.{ScalaDsl, EN}
import org.scalatest.matchers.ShouldMatchers
package support {
  trait WebSteps extends ScalaDsl with EN with ShouldMatchers with Config with Helpers with Browser with UIServer {
  }
}
