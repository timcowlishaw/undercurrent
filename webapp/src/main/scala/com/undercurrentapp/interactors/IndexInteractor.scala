import akka.actor.Actor
import com.undercurrentapp.web.Messages._
package com.undercurrentapp.interactors {
  class IndexInteractor(private val templateRenderer : com.undercurrentapp.web.TemplateRenderer) extends Actor {
    def receive = {
      case Get(request) => request.complete(templateRenderer.render("index"))
    }
  }
}
