import spray.routing.HttpServiceActor
package com.undercurrent.web {
  class RequestRouter extends HttpServiceActor {
    def receive = runRoute {
      path("") {
        get {
          complete("<h1>Welcome to Undercurrent!</h1>")
        }
      }
    }
  }
}
