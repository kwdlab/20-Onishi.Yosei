import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().trim().toInt)

    val b = a.filter(_ >= k)
    
    b.foreach(println)
}