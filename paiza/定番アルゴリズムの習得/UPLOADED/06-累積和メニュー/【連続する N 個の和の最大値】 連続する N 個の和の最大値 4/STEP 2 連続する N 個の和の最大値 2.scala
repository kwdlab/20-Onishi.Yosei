import scala.io.StdIn._

object Main extends App {

    val a = readLine().split(" ").map(_.toInt)
    val n = a.length
    val s = Array.ofDim[Int](n+1)

    for (i <- 0 until n+1){
        if (i == 0){
            s(i) = 0
        } else {
            s(i) = a(i-1) + s(i-1)
        }
    }

    var max = 0
    for (i <- 0 until 8){
        max = max.max(s(i+3)-s(i))
    }
    println(max)
}
