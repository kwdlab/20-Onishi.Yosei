import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val g = Array.ofDim[Int](n, n)

    for (_ <- 1 until n) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g(a - 1)(b - 1) = 1
        g(b - 1)(a - 1) = 1
    }

    var index = 0
    for (_ <- 0 until n) {
        println(index + 1)
        if (g(index).contains(1)) {
            val nextIndex = g(index).indexOf(1)
            g(nextIndex)(index) = 0
            index = nextIndex
        }
    }
}

//解答例使用済み