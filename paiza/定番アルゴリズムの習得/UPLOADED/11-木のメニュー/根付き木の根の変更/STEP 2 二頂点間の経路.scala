import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, a, b) = readLine().split(" ").map(_.toInt)

    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    val previous = Array.fill(n)(-1)
    previous(a - 1) = -2
    val q = Queue[Int](a - 1)
    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- graph(now)) {
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

    ans.append(now).reverse.foreach(i => println(i+1))
}
//解答例使用済み