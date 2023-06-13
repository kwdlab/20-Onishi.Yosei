import scala.io.StdIn._
import Math._

object Main extends App {

    val num = readLine().toInt

    for (i <- 0 until num){
        println(pow(2, i+1).round)
    }
}
