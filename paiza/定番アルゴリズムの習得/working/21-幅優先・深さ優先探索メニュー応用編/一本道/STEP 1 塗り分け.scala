import scala.collection.mutable.Stack
import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val graph = Array.fill(n)(List.empty[Int])
    val visited = Array.fill(n)(false)
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    dfs(graph, visited, 0)
    println(2)
    visited.foreach(if (_) println(1) else println(2))

    def dfs(graph: Array[List[Int]], visited: Array[Boolean], start: Int): Unit = {
        val stack = Stack(start)
        visited(start) = true

        while (stack.nonEmpty) {
            val now = stack.pop()
            for (next <- graph(now)) {
                if (!visited(next)) {
                    visited(next) = !visited(now)
                    stack.push(next)
                }
            }
        }
    }
}

//再帰限界テストケース

/*
import scala.io.StdIn._
import scala.annotation.tailrec

object Main extends App {

    val n = readLine().toInt
    val graph = Array.fill(n)(List.empty[Int])
    val visited = Array.fill(n)(false)
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }
    
    visited(0) = true
    dfs(graph, visited, 0)
    println(2)
    visited.foreach(if(_) println(1) else println(2))
    
    def dfs(graph: Array[List[Int]], visited: Array[Boolean], now: Int): Unit = {
        for (next <- graph(now)){
            if (!visited(next)) {
                visited(next) = !visited(now)
                dfs(graph, visited, next)
            }
        }
    }
}
*/