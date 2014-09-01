import akka.actor.Props
import spray.routing.HttpServiceActor
import com.undercurrentapp.web.Messages._
import com.undercurrentapp.interactors._

package com.undercurrent.web {
  class RequestRouter extends HttpServiceActor {
    def receive = runRoute {
      path("") {
        get { request =>
          context.actorOf(Props[IndexInteractor]) ! Get(request)
        }
      }
    }
  }
}
