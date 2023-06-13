import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, a, b) = readLine().split(" ").map(_.toInt)
    val g = Array.fill(n)(ArrayBuffer.empty[Int])

    for (_ <- 1 until n) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g(a-1).append(b-1)
        g(b-1).append(a-1)
    }

    val previous = Array.fill(n)(-1)
    previous(a - 1) = -2

    val q = Queue[Int](a - 1)

    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- g(now)) {
            if (previous(nxt) == -1) {
                previous(nxt) = now
                q.enqueue(nxt)
            }
        }
    }

    var ans = ArrayBuffer.empty[Int]
    var now = b - 1

    while (previous(now) != -2) {
        ans.append(now)
        now = previous(now)
    }

    ans.append(now)
    for (i <- ans.reverse) {
        println(i + 1)
    }
}

//解答例使用済み