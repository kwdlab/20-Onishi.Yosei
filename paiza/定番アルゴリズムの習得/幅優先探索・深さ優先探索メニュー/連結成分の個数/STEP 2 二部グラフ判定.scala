import scala.io.StdIn._

object Main extends App {
    
    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }

    var ok = true
    val color = Array.fill(n)(0)

    def dfs(now: Int, num: Int): Unit = {
        color(now) = num
        for (i <- graph(now).indices) {
            val next = graph(now)(i)
            if (color(next) == 0) {
                dfs(next, -num)
            } else {
                if (color(now) == color(next)) {
                ok = false
                }
            }
        }
    }

    for (i <- 0 until n) {
        if (color(i) == 0) {
            dfs(i, 1)
        }
    }

    if (ok) {
        println("Yes")
    } else {
        println("No")
    }
}

//解答例使用済み