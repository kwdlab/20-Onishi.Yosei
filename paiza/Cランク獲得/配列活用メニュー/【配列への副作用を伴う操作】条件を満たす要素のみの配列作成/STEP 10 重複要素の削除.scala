import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)

    val b = a.distinct
    
    b.foreach(println)
}