import scala.io.StdIn._

object Main extends App {
    val num = readLine().toInt
    val line = readLine().split(" ")
    for (i <- 0 until num){
        println(line(i))
    }
}
