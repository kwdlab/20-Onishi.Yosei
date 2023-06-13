import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue

object Main extends App {
    val Array(n, r) = readLine().trim().split(" ").map(_.toInt)

    val g = Array.fill(n)(ArrayBuffer.empty[Int])
    val edge = Array.ofDim[Int](n - 1, 2)
    for (i <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        edge(i) = Array(a - 1, b - 1)
        g(a - 1) += b - 1
        g(b - 1) += a - 1
    }

    val dist = Array.fill(n)(n)
    val q = Queue.empty[Int]
    q.enqueue(r - 1)
    dist(r - 1) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- g(now)) {
            if (dist(nxt) == n) {
                dist(nxt) = dist(now) + 1
                q.enqueue(nxt)
            }
        }
    }

    for (i <- 0 until n - 1) {
        val Array(a, b) = edge(i)
        if (dist(a) < dist(b)) {
            println("A")
        } else {
            println("B")
        }
    }
}

//解答例使用済み
//問われているものが理解できない