import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {
 
    def dfs(graph: Array[Array[Int]], size: Array[Long], now: Int): Unit = {
        val stack = Stack[Int]()
        stack.push(now)

        while (stack.nonEmpty) {
            val curr = stack.pop()

            for (next <- graph(curr)) {
                stack.push(next)
                size(curr) += size(next)
            }
        }
    }

    val n = readLine().trim().toInt
    val graph = Array.ofDim[Int](n, n)
    val name = Array.ofDim[String](n)
    val size = Array.ofDim[Long](n)

    for (i <- 0 until n) {
        val input = readLine().trim().split(" ")
        name(i) = input(0)
        size(i) = input(1).toLong
        val num = input(2).toInt

        for (j <- 0 until num) {
            graph(i)(j) = input(j+3).toInt
        }
    }

    dfs(graph, size, 0)
    for (i <- 0 until n) {
        println(name(i) + " " + size(i))
    }
}

//再帰はオーバーフロー