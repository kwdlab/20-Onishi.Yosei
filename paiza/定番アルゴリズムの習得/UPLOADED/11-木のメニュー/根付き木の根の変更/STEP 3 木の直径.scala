import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    def bfs(s: Int, graph: Array[List[Int]]): Array[Int] = {
        val dist = Array.fill(n)(-1)
        dist(s) = 0
        val q = Queue(s)

        while (q.nonEmpty) {
            val now = q.dequeue()
            for (nxt <- graph(now)) {
                if (dist(nxt) == -1) {
                    dist(nxt) = dist(now) + 1
                    q.enqueue(nxt)
                }
            }
        }
        dist
    }

    val n = readLine().toInt
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    def printOut():Unit = {
        val distFromZero = bfs(0, graph)
        val maxDist = distFromZero.max

        for ((dist, i) <- distFromZero.zipWithIndex) {
            if (dist == maxDist) {
                println(bfs(i, graph).max)
                return
            }
        }        
    }
    printOut()
}

//解答例使用済み