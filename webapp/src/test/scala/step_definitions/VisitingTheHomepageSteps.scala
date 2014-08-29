import support.WebSteps
package step_definitions {
  class VistingTheHomepageSteps extends WebSteps {
    When("""^I visit the homepage$""") { () =>
      go to path("/")
    }

    Then("""^I should see information about Undercurrent$""") { () =>
      page.text should include("Welcome to Undercurrent")
    }
  }
}
