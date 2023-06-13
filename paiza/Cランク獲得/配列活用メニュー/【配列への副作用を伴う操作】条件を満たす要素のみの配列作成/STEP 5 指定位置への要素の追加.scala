import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)
    
    val Array(b, x) = readLine().trim().split(" ").map(_.toInt)
    val newA = a.take(b) ++ Array(x) ++  a.drop(b)

    newA.foreach(println)
}