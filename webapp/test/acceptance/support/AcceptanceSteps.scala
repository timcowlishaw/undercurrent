package com.undercurrentapp.webapp {
  package test.acceptance.support {

    import cucumber.api.scala.{ScalaDsl, EN}
    import cucumber.api.PendingException
    import org.scalatest.Matchers
    import org.scalatest.selenium.Firefox
    import org.openqa.selenium.NoSuchElementException
    import play.api.test.TestServer

    sealed trait ServerLifeCycle {
      self : ScalaDsl with EN with Config =>
      val server = new TestServer(port)

      Before { _ =>
        server.start
      }

      After { _ =>
        server.stop
      }
    }

    sealed trait Browser extends Firefox {
      self: ScalaDsl with EN =>
        After { _ =>
          quit
        }
    }

    sealed trait Helpers {
      self : Browser =>
      def pending : Unit = {
        throw new PendingException
      }

      def page = find(tagName("body")).getOrElse {
        throw new NoSuchElementException("Page has no <body> element")
      }
    }

  sealed trait Paths {
    self : Config =>

    val homepage = url("")

    private def url(path : String) = s"$host/$path"
  }

    sealed trait Config {
      val port = 9876
      val host = s"http://localhost:$port"
    }


    class AcceptanceSteps extends ScalaDsl
      with EN with Matchers
      with Config with Helpers with Paths
      with Browser with ServerLifeCycle {
    }
  }
}
