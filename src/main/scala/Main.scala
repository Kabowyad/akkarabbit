import akka.actor.ActorSystem
import com.newmotion.akka.rabbitmq._

object Main extends App {
  implicit val system = ActorSystem()
  val factory = new ConnectionFactory
}
