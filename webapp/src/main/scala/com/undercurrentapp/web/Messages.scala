import spray.routing.RequestContext
package com.undercurrentapp.web {
  object Messages {
    case class Get(request : RequestContext)
    case class Post(request : RequestContext)
    case class Delete(request : RequestContext)
    case class Put(request : RequestContext)
  }
}
