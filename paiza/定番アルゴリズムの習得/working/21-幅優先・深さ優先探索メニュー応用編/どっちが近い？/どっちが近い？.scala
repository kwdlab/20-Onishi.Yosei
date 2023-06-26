import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    def bfs(graph: Array[List[Int]], x: Int): Array[Int] = {
        val q = Queue[Int]()
        q.enqueue(x)
        val dist = Array.fill(graph.length)(-1)
        dist(x) = 0

        while (q.nonEmpty) {
            val now = q.dequeue()
            for (next <- graph(now)) {
                if (dist(next) == -1) {
                    dist(next) = dist(now) + 1
                    q.enqueue(next)
                }
            }
        }
        return dist
    }

    val Array(n, m, x, y) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])

    for (i <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) = b - 1 :: graph(a - 1)
        graph(b - 1) = a - 1 :: graph(b - 1)
    }

    val distX = bfs(graph, x - 1)
    val distY = bfs(graph, y - 1)

    for (i <- 0 until n) {
        if (distX(i) < distY(i)) {
            println("X is closer")
        } else if (distX(i) == distY(i)) {
            println("Same")
        } else {
            println("Y is closer")
        }
    }
}

//解答例使用済み