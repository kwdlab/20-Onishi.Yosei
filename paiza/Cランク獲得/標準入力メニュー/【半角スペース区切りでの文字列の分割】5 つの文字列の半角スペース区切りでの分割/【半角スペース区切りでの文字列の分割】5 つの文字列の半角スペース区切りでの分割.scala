import scala.io.StdIn._

object Main extends App {

    val input = "one two three four five"
    val line = input.split(" ")
    for (i <- 0 until 5){
        println(line(i))
    }
}