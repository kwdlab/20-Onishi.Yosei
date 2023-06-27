import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    val distance = Array.fill(n)(-1)
    distance(x - 1) = 0
    val q = Queue[Int](x-1)
    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- graph(now)) {
            if (distance(nxt) == -1) {
                distance(nxt) = distance(now) + 1
                q.enqueue(nxt)
            }
        }
    }
    distance.zipWithIndex.foreach { case (dist, index) =>
        if (dist == 3) println(index+1)
    }
}
//解答例使用済み