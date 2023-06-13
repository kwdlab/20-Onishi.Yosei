import scala.io.StdIn._

object Main extends App {

    val input = "Hello paiza"
    val line = input.split(" ")
    for (i <- 0 until 2){
        println(line(i))
    }
}