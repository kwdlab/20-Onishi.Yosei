import scala.io.StdIn._

object Main extends App {

    val Array(n, m, x) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }
    for (i <- 0 until n){
        graph(i) = graph(i).sorted
    }

    val unvisited = Array.fill(n)(true)

    def dfs(now: Int): Unit = {
        unvisited(now) = false
        println(now + 1)
        for (nxt <- graph(now)) {
            if (unvisited(nxt)) dfs(nxt)
        }
    }

    dfs(x-1)
}
