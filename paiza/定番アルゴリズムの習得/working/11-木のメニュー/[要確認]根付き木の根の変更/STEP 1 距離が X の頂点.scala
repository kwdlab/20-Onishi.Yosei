import scala.io.StdIn._
import scala.collection.mutable.Queue
import scala.collection.mutable.ArrayBuffer

object Main extends App {
    val Array(n, a, x) = readLine().split(" ").map(_.toInt)

    val g = Array.fill(n)(ArrayBuffer.empty[Int])
    for (_ <- 1 until n) {
        val line = readLine().split(" ").map(_.toInt)
        val a = line(0) - 1
        val b = line(1) - 1
        g(a) += b
        g(b) += a
    }

    val q = Queue[Int]()
    q.enqueue(a - 1)
    val dist = Array.fill(n)(1000)
    dist(a - 1) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- g(now)) {
            if (dist(nxt) == 1000) {
                dist(nxt) = dist(now) + 1
                q.enqueue(nxt)
            }
        }
    }

    for (i <- 0 until n) {
        if (dist(i) == x) {
            println(i + 1)
        }
    }
}

//解答例使用済み