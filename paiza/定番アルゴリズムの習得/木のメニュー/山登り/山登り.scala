import scala.io.StdIn._
import scala.collection.mutable.ListBuffer

object Main extends App {

    def calcLength(now: Int): Unit = {
        for (nxt <- g(now)) {
            if (lenFromT(nxt) == -1) {
                lenFromT(nxt) = lenFromT(now) + 1
                parent(nxt) = now
                calcLength(nxt)
            }
        }
    }

    val Array(n, t, s, c, d) = readLine().split(" ").map(_.toInt)

    val g = Array.fill(n)(ListBuffer[Int]())
    for (_ <- 1 until n) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g(a - 1).append(b - 1)
        g(b - 1).append(a - 1)
    }

    val parent = Array.ofDim[Int](n)
    val lenFromT = Array.fill(n)(-1)
    parent(t - 1) = -1
    lenFromT(t - 1) = 0

    calcLength(t - 1)

    if (lenFromT(s - 1) <= c) {
        for (i <- 0 until n) {
            if (lenFromT(i) == lenFromT(s - 1) - c + d) {
            println(i + 1)
            }
        }
    } else {
        var highest = s - 1
        for (_ <- 0 until c) {
            highest = parent(highest)
        }

        for (i <- 0 until n) {
            if (lenFromT(i) == lenFromT(s - 1) - c + d) {
                var ancestor = i
                for (_ <- 0 until d) {
                    ancestor = parent(ancestor)
                }

                if (ancestor == highest) {
                    println(i + 1)
                }
            }
        }
    }

}
//解答例使用済み
//断念
//総探索は無理らしい