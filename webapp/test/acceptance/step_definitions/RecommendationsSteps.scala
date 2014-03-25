package com.undercurrentapp.webapp {
  package test.acceptance {
    package step_definitions {

      import support.AcceptanceSteps

      class RecommendationsSteps extends AcceptanceSteps {
        Given("""^I am on the Undercurrent homepage$"""){ () =>
          go to homepage
        }

        When("""^I enter the details of my home into the savings calculator$"""){ () =>
          pending
        }

        Then("""^I should see a list of possible energy saving interventions$"""){ () =>
          pending
        }

        Then("""^I should see estimated cost and carbon savings for each intervention$"""){ () =>
          pending
        }
      }
    }
  }
}
