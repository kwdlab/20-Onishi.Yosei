import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    def bfs(s: Array[Array[String]], n: Int, m: Int, x: Int, y: Int, c: String): Unit = {
        val q = Queue[(Int, Int)]((x, y))

        val dx = Array(1, 0, -1, 0)
        val dy = Array(0, 1, 0, -1)
        s(x)(y) = "+"

        while (q.nonEmpty) {
            val (nowX, nowY) = q.dequeue()

            for (i <- 0 until 4) {
                val nextX = nowX + dx(i)
                val nextY = nowY + dy(i)

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {}
                else if (s(nextX)(nextY) != c) {}
                else {
                    s(nextX)(nextY) = "+"
                    q.enqueue((nextX, nextY))
                }
            }
        }
    }

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val s = Array.fill(n)(readLine().trim().split(""))

    val rgb = Array("R", "G", "B")
    var ans = Int.MaxValue
    for (c <- rgb) {
        val t = s.map(_.clone())
        for (i <- 0 until n; j <- 0 until m) {
            if (t(i)(j) != c) t(i)(j) = "."
        }

        var cnt = 0
        for (i <- 0 until n; j <- 0 until m) {
            if (t(i)(j) != "+") {
                cnt += 1
                bfs(t, n, m, i, j, t(i)(j))
            }
        }
        ans = Array(ans, cnt).min
    }

    println(ans)
}
//解答例使用済み