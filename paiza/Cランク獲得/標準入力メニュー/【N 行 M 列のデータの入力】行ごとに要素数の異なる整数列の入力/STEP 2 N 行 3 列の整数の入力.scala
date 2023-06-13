import scala.io.StdIn._

object Main extends App {
    val num = readLine().toInt

    for (i <- 0 until num){
        val line = readLine()
        println(line)
    }
}