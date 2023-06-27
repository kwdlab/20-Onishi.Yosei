import scala.io.StdIn._

object Main extends App {

    def dfs(graph: Array[List[Int]], visited: Array[Boolean], now: Int): Int = {
        visited(now) = true
        val tmp = graph(now).flatMap { next =>
            if (!visited(next)) Some(dfs(graph, visited, next))
            else None
        }
        val sum = tmp.sum
        val cnt = tmp.length

        if (now == 0) {
            sum + math.min(2, cnt)
        } else {
            sum + math.min(1, cnt)
        }
    }

    val n = readLine().toInt
    val graph = Array.fill(n)(List.empty[Int])
    val visited = Array.fill(n)(false)
    for (_ <- 0 until n-1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }
    for (i <- 0 until n){
        graph(i) = graph(i).sorted
    }

    println(dfs(graph, visited, 0))
}

//Exception in thread "main" java.lang.StackOverflowError
//再帰は無理
//軽い入力に対しては動作することを確認