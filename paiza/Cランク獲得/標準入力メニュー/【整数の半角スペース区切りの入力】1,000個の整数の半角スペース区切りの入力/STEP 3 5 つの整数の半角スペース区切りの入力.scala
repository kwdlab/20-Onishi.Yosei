import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    for (i <- 0 until 5){
        println(line(i).toInt)
    }
}