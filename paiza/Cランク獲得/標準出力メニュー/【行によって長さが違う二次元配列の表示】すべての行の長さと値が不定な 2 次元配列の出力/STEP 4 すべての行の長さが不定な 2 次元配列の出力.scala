import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val line = readLine().split(" ").map(_.toInt)
    
    for (i <- 0 until n){
        println((1 to line(i)).mkString(" "))
    }
}