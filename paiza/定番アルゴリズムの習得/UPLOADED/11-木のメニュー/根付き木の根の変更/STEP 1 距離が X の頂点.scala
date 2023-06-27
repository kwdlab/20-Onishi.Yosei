import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, a, x) = readLine().split(" ").map(_.toInt)

    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    val q = Queue[Int](a-1)
    val dist = Array.fill(n)(1000)
    dist(a - 1) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- graph(now)) {
            if (dist(nxt) == 1000) {
                dist(nxt) = dist(now) + 1
                q.enqueue(nxt)
            }
        }
    }

    for (i <- 0 until n) {
        if (dist(i) == x) println(i + 1)
    }
}
//解答例使用済み