import org.scalatest.selenium.Chrome
import cucumber.api.scala.{ScalaDsl, EN}
import cucumber.api.Scenario

trait Browser extends Chrome {
  self: ScalaDsl with EN =>

  After { (_ : Scenario) =>
    quit
  }
}
