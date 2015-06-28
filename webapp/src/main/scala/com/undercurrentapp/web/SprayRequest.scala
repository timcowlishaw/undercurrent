import spray.routing.RequestContext;
import spray.httpx.marshalling.ToResponseMarshaller;
import com.undercurrentapp.web.Request;
package com.undercurrentapp.web {
  class SprayRequest(val context : RequestContext) extends Request[ToResponseMarshaller] {
    def complete[T : ToResponseMarshaller](response : T) = context.complete(response)
  }
}
