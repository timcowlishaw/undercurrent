import akka.actor.Actor
import com.undercurrentapp.web.Messages._
package com.undercurrentapp.interactors {
  class IndexInteractor extends Actor {
    def receive = {
      case Get(request) => request.complete("<h1>Welcome to Undercurrent!</h1>")
    }
  }
}
