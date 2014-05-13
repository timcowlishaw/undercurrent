import cucumber.api.PendingException
import cucumber.api.scala.{ScalaDsl, EN}

package step_definitions {
  class VistingTheHomepageSteps extends ScalaDsl with EN  {
    When("""^I visit the homepage$"""){ () =>
      throw new PendingException()
    }

    Then("""^I should see information about Undercurrent$"""){ () =>
      throw new PendingException()
    }
  }
}
