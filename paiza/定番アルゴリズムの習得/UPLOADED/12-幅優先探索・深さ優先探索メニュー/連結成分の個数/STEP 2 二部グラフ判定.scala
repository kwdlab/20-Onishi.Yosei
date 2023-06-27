import scala.io.StdIn._

object Main extends App {
    
    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    var ok = true
    val color = Array.fill(n)(0)

    def dfs(now: Int, num: Int): Unit = {
        color(now) = num
        for (nxt <- graph(now)) {
            if (color(nxt) == 0) dfs(nxt, -num)
            else if (color(now) == color(nxt)) ok = false
        }
    }

    for (i <- 0 until n) {
        if (color(i) == 0) dfs(i, 1)
    }

    if (ok) println("Yes")
    else println("No")
}

//解答例使用済み