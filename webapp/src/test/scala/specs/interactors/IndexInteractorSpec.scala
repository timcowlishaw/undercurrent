import org.scalatest._
import org.scalatest.mock.MockitoSugar
import org.mockito.Mockito._
import org.mockito.Matchers._
import akka.testkit.TestActorRef
import spray.routing.RequestContext //TODO - can we factor out these dependencies on spray?
import spray.httpx.marshalling.ToResponseMarshaller

import com.undercurrentapp.web.Messages._
import com.undercurrentapp.interactors.IndexInteractor

class IndexInteractorSpec extends WordSpec with Matchers with MockitoSugar {
  implicit val system = akka.actor.ActorSystem("IndexInteractorSpec")

  "The index interactor" when {
    "receiving a GET message" should {
      "Respond with the welcome message" in {
        val request = mock[RequestContext]
        val ref = TestActorRef[IndexInteractor]
        ref ! Get(request)
        verify(request).complete(same("<h1>Welcome to Undercurrent!</h1>"))(any(classOf[ToResponseMarshaller[String]]))
      }
    }
  }
}
