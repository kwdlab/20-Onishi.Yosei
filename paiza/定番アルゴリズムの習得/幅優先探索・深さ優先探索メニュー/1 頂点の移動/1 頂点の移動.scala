import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x, y) = readLine().split(" ").map(_.toInt)
    val xIndex = x - 1
    val yIndex = y - 1

    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }

    for (i <- 0 until n) {
        graph(i) = graph(i).sorted
    }

    val dfs_unvisited = Array.fill(n)(true)
    val bfs_unvisited = Array.fill(n)(true)
    var bfs_count = 0
    var dfs_count = 0

    def dfs(now: Int): Unit = {
        dfs_unvisited(now) = false
        if (dfs_unvisited(yIndex)) {
            dfs_count += 1
        }
        for (i <- 0 until graph(now).length) {
            if (dfs_unvisited(graph(now)(i))) {
                dfs(graph(now)(i))
            }
        }
    }

    def bfs(): Unit = {
        val q = Queue[Int]()
        q.enqueue(xIndex)
        bfs_unvisited(xIndex) = false
        while (q.nonEmpty) {
            val now = q.dequeue()
            if (now == yIndex) {
                return
            } else {
                bfs_count += 1
            }
            for (nxt <- graph(now)) {
                if (bfs_unvisited(nxt)) {
                    bfs_unvisited(nxt) = false
                    q.enqueue(nxt)
                }
            }
        }
    }

    dfs(xIndex)
    bfs()

    if (bfs_count < dfs_count) {
        println("bfs")
    } else if (bfs_count == dfs_count) {
        println("same")
    } else {
        println("dfs")
    }
}

//解答例使用済み