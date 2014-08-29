import cucumber.api.scala.{ScalaDsl, EN}
import cucumber.api.Scenario
import akka.actor.ActorSystem
import scala.sys.process.{Process, ProcessLogger}
import java.util.concurrent.Semaphore
import com.undercurrentapp.web.HttpServer

package support {
  trait Server {
    self : ScalaDsl with EN with Config =>

    private class ServerProcess(port : Int) {

      private var server : Option[HttpServer] = None;
      implicit val system = ActorSystem("undercurrent-cucumber")

      def start = {
        server = Some(new HttpServer(port,  "localhost"))
        server.map(_.start)
      }

      def stop = {
        server.map(_.stop)
      }
    }

    private val server = new ServerProcess(uiPort)

    Before { (_ : Scenario) =>
      server.start
    }

    After { (_ : Scenario) =>
      server.stop
    }
  }
}
