import scala.io.StdIn._

object Main extends App {
    val line = readLine().split(" ")
    val num = line(0).toInt

    for (i <- 1 until num+1){
        println(line(i).toFloat)
    }
}