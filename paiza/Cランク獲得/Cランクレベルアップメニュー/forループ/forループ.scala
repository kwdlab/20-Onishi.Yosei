import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k) = readLine().trim().split(" ").map(_.toInt)
    val a = Array.fill[Array[Int]](n)(readLine().split(" ").map(_.toInt))

    for (i <- a){
        println(i.count(_ == k))
    }
}
