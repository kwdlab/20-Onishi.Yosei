import scala.io.StdIn._
import scala.collection.mutable.Queue
object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(Array.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) = graph(a - 1) ++ Array(b - 1)
        graph(b - 1) = graph(b - 1) ++ Array(a - 1)
    }

    val l = Array.fill(n)(-1)
    l(x - 1) = 0
    val q = Queue[Int]()
    q.enqueue(x - 1)
    while (q.nonEmpty) {
        val prev = q.dequeue()
        for (nxt <- graph(prev)) {
            if (l(nxt) == -1) {
                l(nxt) = l(prev) + 1
                q.enqueue(nxt)
            }
        }
    }

    for (i <- 0 until n) {
        if (l(i) == 3) {
            println(i + 1)
        }
    }
}
//解答例使用済み