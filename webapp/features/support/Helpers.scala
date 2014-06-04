import org.openqa.selenium.NoSuchElementException
import cucumber.api.PendingException
package support {
  trait Helpers {
    self : Config with Browser =>

    def page = find(tagName("body")).getOrElse {
      throw new NoSuchElementException("Page has no <body> element")
    }

    def pending = throw new PendingException();

    def path(parts : String*) = (uiHost +: parts.map("^\\/".r.replaceFirstIn(_, "")) ).mkString("/")
  }
}
