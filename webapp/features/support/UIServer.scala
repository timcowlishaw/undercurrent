import cucumber.api.scala.{ScalaDsl, EN}
import cucumber.api.Scenario
import scala.sys.process.{Process, ProcessLogger}
import java.util.concurrent.Semaphore

package support {
  trait UIServer {
    self : ScalaDsl with EN with Config =>

    private class UIServerProcess(command : String, port : Int, root : String, readyMessage : String) {

      private val lock = new Semaphore(0)
      private var process : Option[Process] = None

      def start = {
        val logger = ProcessLogger { (line : String) =>
          if (line.contains(readyMessage)) lock.release
        }
        val cwd = new java.io.File(root)
        val processBuilder = Process(command, cwd, "UI_PORT" -> port.toString)
        process = Some(processBuilder.run(logger))
        lock.acquire
      }

      def stop = {
        process.map(_.destroy)
      }

    }

    private val server = new UIServerProcess(uiCommand, uiPort, uiRoot, uiReadyMessage)

    Before { (_ : Scenario) =>
      server.start
    }

    After { (_ : Scenario) =>
      server.stop
    }
  }
}
