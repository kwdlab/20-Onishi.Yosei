import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {
    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val to = Array.ofDim[Int](n, k)

    for (i <- 0 until n) {
        val line = readLine().split(" ").map(_.toInt)
        for (j <- 0 until k) {
            to(i)(j) = line(j) - 1
        }
    }

    val stack = Stack[Int]()
    stack.push(0)

    var now = 0
    for (i <- 0 until k) {
        if (to(now)(i) == -2) {
            stack.pop()
            now = stack.top
        } else {
            now = to(now)(i)
            stack.push(now)
        }
        println(now + 1)
    }
}
//解答例使用済み