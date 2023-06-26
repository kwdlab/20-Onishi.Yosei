import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    def bfs(s: Array[Array[String]], group: Array[Array[Int]], n: Int, m: Int, x: Int, y: Int, c: String, id: Int): Unit = {
        val q = Queue[(Int, Int)]()
        q.enqueue((x, y))

        val dx = Array(1, 0, -1, 0)
        val dy = Array(0, 1, 0, -1)
        group(x)(y) = id

        while (q.nonEmpty) {
            val (nowX, nowY) = q.dequeue()

            for (i <- 0 until 4) {
                val nextX = nowX + dx(i)
                val nextY = nowY + dy(i)

                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {

                } else if (s(nextX)(nextY) != c || group(nextX)(nextY) != 0) {

                } else {
                    group(nextX)(nextY) = id
                    q.enqueue((nextX, nextY))
                }
            }
        }
    }

    val Array(n, m, k) = readLine().trim().split(" ").map(_.toInt)
    val s = Array.ofDim[String](n, m)
    val group = Array.ofDim[Int](n, m)
    var id = 1

    for (i <- 0 until n) {
        s(i) = readLine().trim().split("")
    }

    for (i <- 0 until n; j <- 0 until m) {
        if (group(i)(j) == 0) {
            bfs(s, group, n, m, i, j, s(i)(j), id)
            id += 1
        }
    }

    for (i <- 0 until k) {
        val Array(a, b, c, d) = readLine().trim().split(" ").map(_.toInt)
        val groupA = group(a - 1)(b - 1)
        val groupB = group(c - 1)(d - 1)
        if (groupA == groupB) {
            println("Yes")
        } else {
            println("No")
        }
    }
}
//解答例使用済み