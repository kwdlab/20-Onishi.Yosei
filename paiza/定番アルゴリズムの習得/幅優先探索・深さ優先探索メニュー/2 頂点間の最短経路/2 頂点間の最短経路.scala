import scala.io.StdIn._
import scala.collection.mutable.Queue
object Main extends App {

    val Array(n, x, y) = readLine().split(" ").map(_.toInt)
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
    val prev = Array.fill(n)(-1)
    while (q.nonEmpty) {
        val now = q.dequeue()
        if (now == y - 1) {
            var tmp = y - 1
            var ans: Array[Int] = Array.empty
            while (tmp != -1) {
                ans = ans ++ Array(tmp)
                tmp = prev(tmp)
            }
            for (i <- ans.reverse) {
                println(i + 1)
            }
        } else {
            for (nxt <- graph(now)) {
                if (l(nxt) == -1) {
                    l(nxt) = l(now) + 1
                    prev(nxt) = now
                    q.enqueue(nxt)
                }
            }
        }
    }
}
//解答例使用済み