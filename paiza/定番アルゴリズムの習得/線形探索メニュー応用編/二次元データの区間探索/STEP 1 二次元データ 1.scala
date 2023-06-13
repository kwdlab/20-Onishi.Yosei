import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val sumS = Array.ofDim[Int](n)

    for (i <- 0 until n){
        sumS(i) = readLine().split("").count(_ == ".")
    }
    println(sumS.sum)
}
