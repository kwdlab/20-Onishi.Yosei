import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {
    val input = readLine().trim().split(" ").map(_.toInt)
    val n = input(0)
    val m = input(1)
    val x = input(2) - 1

    val graph = Array.fill(n)(List.empty[Int])

    for (_ <- 0 until m) {
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }
    for (i <- 0 until n) {
        graph(i) = graph(i).sorted.reverse
    }

    val unvisited = Array.fill(n)(true)
    dfs(x)

    def dfs(start: Int): Unit = {
        val stack = Stack[Int]()
        stack.push(start)

        while (stack.nonEmpty) {
            val now = stack.pop()

            if (unvisited(now)) {
                unvisited(now) = false
                println(now + 1)

                for (next <- graph(now)) {
                    if (unvisited(next)) {
                        stack.push(next)
                    }
                }
            }
        }
    }
}
//解答例の再帰が通らないテストケース
//再帰の限界

/*
import scala.io.StdIn._

object Main extends App {

    def dfs(now: Int, unvisited: Array[Boolean], graph: Array[List[Int]]): Unit = {
        unvisited(now) = false
        println(now + 1)
        for (i <- graph(now).indices) {
            val next = graph(now)(i)
            if (unvisited(next)) {
                dfs(next, unvisited, graph)
            }
        }
    }

    val input = readLine().trim().split(" ").map(_.toInt)
    val n = input(0)
    val m = input(1)
    val x = input(2) - 1

    val graph = Array.fill(n)(List.empty[Int])

    for (_ <- 0 until m) {
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }

    for (i <- 0 until n) {
        graph(i) = graph(i).sorted
    }

    val unvisited = Array.fill(n)(true)
    dfs(x, unvisited, graph)
}
*/