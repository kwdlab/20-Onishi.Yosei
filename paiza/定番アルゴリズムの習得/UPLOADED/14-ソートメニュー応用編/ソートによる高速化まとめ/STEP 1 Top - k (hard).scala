import scala.io.StdIn._

object Main extends App {

    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)
    val k = readLine().split(" ").map(_.toInt)
    val aRev = a.sorted.reverse

    for (i <- k){
        println(aRev(i-1))
    }
}