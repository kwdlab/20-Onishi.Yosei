import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, _) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    val Array(k, r) = readLine().split(" ").map(_.toInt)
    val q = Queue[Int](r-1)
    val dist = Array.fill(n)(-1)
    dist(r - 1) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- graph(now)) {
            if (dist(nxt) == -1) {
                dist(nxt) = dist(now) + 1
                q.enqueue(nxt)
            }
        }
    }
    for (_ <- 1 to k) {
        val v = readLine().toInt - 1
        graph(v).foreach(i => if (dist(i) + 1 == dist(v)) println(i + 1))
    }
}
//解答例使用済み