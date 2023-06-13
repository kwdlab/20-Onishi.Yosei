import scala.io.StdIn._

object Main extends App {
    val input = readLine().split(" ")
    val num = input(0).toInt

    for (i <- 0 until num){
        val line = readLine()
        println(line)
    }
}