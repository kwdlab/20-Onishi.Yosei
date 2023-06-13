import scala.io.StdIn._
import Math._

object Main extends App {

    val num = readLine().toInt

    for (i <- 0 until num){
        val line = readLine().split(" ").map(_.toInt)
        val result = abs(line(0)-2) + abs(line(1)-3)
        println(result)
    }
}
