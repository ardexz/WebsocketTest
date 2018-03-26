import scala.concurrent.ExecutionContext.Implicits._
import scala.concurrent._
import play.api.libs.ws.ahc.AhcWSClient
import org.scalatest.concurrent.ScalaFutures
import org.scalatestplus.play.guice.GuiceOneAppPerSuite
import org.scalatest._
import akka.stream.{ ActorMaterializer, OverflowStrategy }
import akka.actor.ActorSystem
import akka.{ Done, NotUsed }
import akka.http.scaladsl.Http
import akka.stream.scaladsl._
import akka.http.scaladsl.model._
import akka.http.scaladsl.model.ws._

import scala.concurrent.Future

class HelloSpec
  extends FlatSpec
  with Matchers
  with GuiceOneAppPerSuite
  with ScalaFutures {
  import play.api.libs.json._
  // import System.dispatcher

  "Hello" should "have tests" in {
    implicit val system = ActorSystem()
    implicit val materializer = ActorMaterializer()
    import system.dispatchers

    val json = Json.parse("""{
        "command" : "get_balance",
        "id_account_ref": "dc59a3e6-c2e8-49d6-9ee3-5e39ad5264d5" }""")

    val flow: Flow[Message, Message, Promise[Option[Message]]] =
      Flow.fromSinkAndSourceMat(
        Sink.foreach[Message](println),
        Source(List(TextMessage(json.toString)))
          .concatMat(Source.maybe[Message])(Keep.right))(Keep.right)


    val (upgradeResponse, promise) =
      Http().singleWebSocketRequest(
        WebSocketRequest("ws://127.0.0.1:9000"),
        flow)

    // at some later time we want to disconnect
    promise.future.map(_.map(r => println("response:"+ r )))
    promise
  }
}
