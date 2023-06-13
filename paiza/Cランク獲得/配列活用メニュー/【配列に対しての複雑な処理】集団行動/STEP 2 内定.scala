import scala.io.StdIn._

object Main extends App {
 
    val Array(n, k, m) = readLine().trim().split(" ").map(_.toInt)
    val a = Array.ofDim[Int](n)

    for (i <- 0 until n){
        a(i) = readLine().trim().toInt
    }

    val count = a.count(_ >= k) - m
    if (count < 0){
        println(0)
    } else {
        println(count)
    }
}