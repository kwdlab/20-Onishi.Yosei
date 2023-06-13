import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    for (i <- 0 until n){
        println(readLine().trim().toInt)
    }
}