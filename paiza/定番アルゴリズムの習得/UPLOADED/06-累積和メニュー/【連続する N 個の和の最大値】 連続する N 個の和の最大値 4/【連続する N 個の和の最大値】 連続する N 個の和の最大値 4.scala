import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)
    val s = Array.ofDim[Int](n+1)

    for (i <- 0 until n+1){
        if (i == 0){
            s(i) = 0
        } else {
            s(i) = a(i-1) + s(i-1)
        }
    }

    var max = 0
    for (i <- 0 until n-k+1){
        max = max.max(s(i+k)-s(i))
    }
    println(max)
}
