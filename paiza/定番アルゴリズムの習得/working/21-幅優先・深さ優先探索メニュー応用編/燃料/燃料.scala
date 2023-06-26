import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    def dfs(graph: Array[List[Int]], visited: Array[Boolean], start: Int): Int = {
        val stack = Stack[(Int, Int)]((start, -1))
        visited(start) = true
        var sum = 0

        while (stack.nonEmpty) {
            val (now, parent) = stack.top
            stack.pop()

            var cnt = 0
            for (next <- graph(now)) {
                if (!visited(next) && next != parent) {
                stack.push((next, now))
                visited(next) = true
                cnt += 1
                }
            }

            if (now == 0) {
                sum += math.min(2, cnt)
            } else {
                sum += math.min(1, cnt)
            }
        }
        sum
    }

    val n = readLine().toInt
    val graph = Array.fill(n)(List.empty[Int])
    val visited = Array.fill(n)(false)
    for (_ <- 0 until n - 1) {
        val Array(a, b) = StdIn.readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    println(dfs(graph, visited, 0))
}



//解答例使用済み
//再帰限界テストケースあり
/*
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
*/