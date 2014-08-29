import scala.util.control.Exception.catching
import scala.concurrent.Await
import scala.concurrent.duration._
import akka.io.IO
import akka.actor.{ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import spray.can.Http
import com.undercurrent.web.RequestRouter
package com.undercurrentapp.web {
  object HttpServer extends App {

    val interface = sys.env.get("UC_INTERFACE").getOrElse("localhost")
    val port = sys.env.get("UC_PORT")
      .flatMap { (s : String) => catching(classOf[NumberFormatException]).opt(s.toInt) }
      .getOrElse(8080)

    implicit val system = ActorSystem("com.undercurrentapp.web.HttpServer")

    val server = new HttpServer(port, interface)
    server.start
  }

  class HttpServer(port : Int, interface : String)(implicit system : ActorSystem) {

    val listener = system.actorOf(Props[RequestRouter])
    val endpoint = IO(Http)

    implicit val timeout = Timeout(30 seconds)

    def start = {
      val future = endpoint ? Http.Bind(listener, interface=interface, port=port)
      Await.result(future, timeout.duration)
    }

    def stop = {
      val future = endpoint ! Http.Unbind
    }
  }
}
