import akka.actor.Props
import spray.routing.HttpServiceActor
import com.undercurrentapp.web.Services
import com.undercurrentapp.web.Messages._
import com.undercurrentapp.interactors._

package com.undercurrentapp.web {
  class RequestRouter extends HttpServiceActor {

    val services =  Services

    def receive = runRoute {
      path("") {
        get { request =>
          context.actorOf(Props(classOf[IndexInteractor], services.templateRenderer)) ! Get(request)
        }
      }
    }
  }
}
