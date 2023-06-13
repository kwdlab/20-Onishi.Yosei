import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val sumA = Array.ofDim[Int](n)

    for (i <- 0 until n){
        sumA(i) = readLine().split(" ").map(_.toInt).count(_ == k)
    }
    println(sumA.sum)
}
