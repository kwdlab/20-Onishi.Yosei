import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, m, x, y) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }
    for (i <- 0 until n){
        graph(i) = graph(i).sorted
    }

    val q = Queue[Int](x - 1)
    val unvisited = Array.fill(n)(true)
    unvisited(x - 1) = false
    while (q.nonEmpty) {
        val now = q.dequeue()
        println(now + 1)
        for (nxt <- graph(now)) {
            if (unvisited(nxt)) {
                unvisited(nxt) = false
                q.enqueue(nxt)
            }
        }
    }
}