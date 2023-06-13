import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")

    for (i <- 0 until line(1).toInt){
        println(line(0))
    }
}
