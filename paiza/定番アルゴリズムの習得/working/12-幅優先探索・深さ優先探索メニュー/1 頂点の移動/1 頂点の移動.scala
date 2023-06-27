import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x, y) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }
    for (i <- 0 until n) {
        graph(i) = graph(i).sorted
    }

    val dfsUnvisited = Array.fill(n)(true)
    val bfsUnvisited = Array.fill(n)(true)
    var bfsCount = 0
    var dfsCount = 0

    def dfs(now: Int): Unit = {
        dfsUnvisited(now) = false
        if (dfsUnvisited(y-1)) dfsCount += 1

        for (nxt <- graph(now)) {
            if (dfsUnvisited(nxt)) dfs(nxt)
        }
    }
    def bfs(): Unit = {
        val q = Queue[Int](x-1)
        bfsUnvisited(x-1) = false
        while (q.nonEmpty) {
            val now = q.dequeue()
            if (now == y-1) return
            else bfsCount += 1

            for (nxt <- graph(now)) {
                if (bfsUnvisited(nxt)) {
                    bfsUnvisited(nxt) = false
                    q.enqueue(nxt)
                }
            }
        }
    }

    dfs(x-1)
    bfs()

    if (bfsCount < dfsCount) {
        println("bfs")
    } else if (bfsCount == dfsCount) {
        println("same")
    } else {
        println("dfs")
    }
}

//解答例使用済み