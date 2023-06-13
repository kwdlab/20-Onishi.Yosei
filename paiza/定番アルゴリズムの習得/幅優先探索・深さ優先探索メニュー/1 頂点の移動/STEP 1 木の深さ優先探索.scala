import scala.io.StdIn._

object Main extends App {

    def dfs(now: Int): Unit = {
        unvisited(now) = false
        println(now + 1)
        for (i <- 0 until graph(now).length) {
            if (unvisited(graph(now)(i))) {
                dfs(graph(now)(i))
            }
        }
    }

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])

    for (_ <- 1 until n) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }

    for (i <- 0 until n) {
        graph(i) = graph(i).sorted
    }

    val unvisited = Array.fill(n)(true)
    dfs(x - 1)
}

//解答例使用済み