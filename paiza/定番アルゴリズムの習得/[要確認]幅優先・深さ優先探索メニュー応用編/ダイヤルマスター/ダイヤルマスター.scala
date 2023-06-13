import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {
    
    def dfs(start: Int, num: Int): Unit = {
        val stack = Stack[(Int, Int)]()
        stack.push((start, num))

        while (stack.nonEmpty) {
            val (now, num) = stack.pop()
            if (color(now) == -1) {
                color(now) = num
                for (next <- graph(now)) {
                    stack.push((next, num))
                }
            }
        }
    }

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])

    for (_ <- 0 until m) {
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }

    var ans = 0
    val color = Array.fill(n)(-1)

    for (i <- 0 until n) {
        if (color(i) == -1) {
        dfs(i, ans)
        ans += 1
        }
    }

    println(ans)
}

//解答例使用済み
//再帰不可テストケースあり