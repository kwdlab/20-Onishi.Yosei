import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)
    
    val Array(x, y) = readLine().split(" ").map(_.toInt)

    val tmp = a(x-1)
    a(x-1) = a(y-1)
    a(y-1) = tmp

    a.foreach(println)
}