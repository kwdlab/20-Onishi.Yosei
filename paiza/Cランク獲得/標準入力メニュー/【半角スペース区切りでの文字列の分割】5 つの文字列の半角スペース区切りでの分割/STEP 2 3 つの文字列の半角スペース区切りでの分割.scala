import scala.io.StdIn._

object Main extends App {

    val input = "He likes paiza"
    val line = input.split(" ")
    for (i <- 0 until 3){
        println(line(i))
    }
}