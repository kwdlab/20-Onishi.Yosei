import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, _) = readLine().split(" ").map(_.toInt)
    val g = Array.fill(n)(ArrayBuffer.empty[Int])
    for (_ <- 1 until n) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g(a - 1).append(b - 1)
        g(b - 1).append(a - 1)
    }

    val Array(k, r) = readLine().split(" ").map(_.toInt)

    val q = Queue[Int]()
    q.enqueue(r - 1)
    val dist = Array.fill(n)(-1)
    dist(r - 1) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- g(now)) {
            if (dist(nxt) == -1) {
                dist(nxt) = dist(now) + 1
                q.enqueue(nxt)
            }
        }
    }

    for (_ <- 1 to k) {
        val v = readLine().toInt - 1
        for (i <- g(v)) {
            if (dist(i) + 1 == dist(v)) {
                println(i + 1)
            }
        }
    }
}
//解答例使用済み