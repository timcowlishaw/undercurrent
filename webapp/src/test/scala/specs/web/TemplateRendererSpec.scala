import org.scalatest._
import com.undercurrentapp.test.Tags._
import com.undercurrentapp.web.TemplateRenderer
import java.nio.file.FileSystems

class TemplateRendererSpec extends WordSpec with Matchers {
  val templatePath = "src/test/resources/fixtures/templates/";
  val renderer = new TemplateRenderer(templatePath);

  "The template renderer" should  {
    "render the named mustache template as a node sequence" taggedAs (Integration) in {
      renderer.render("no_params") should be (<html><head><title>Hello World!</title></head><body></body></html>);

    }
    
    "pass provided parameters to the template" taggedAs (Integration) in {
      renderer.render("params", Map("title" -> "The Title")) should be (<html><head><title>The Title</title></head><body></body></html>);
    }
  }
}
