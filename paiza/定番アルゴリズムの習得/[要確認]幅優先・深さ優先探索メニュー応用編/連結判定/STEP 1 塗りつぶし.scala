import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, m, x, y) = readLine().trim().split(" ").map(_.toInt)
    val s = Array.ofDim[String](n, m)
    for (i <- 0 until n) {
        s(i) = readLine().trim().split("")
    }

    val q = Queue[(Int, Int)]()
    q.enqueue((x - 1, y - 1))

    val dx = Array(1, 0, -1, 0)
    val dy = Array(0, 1, 0, -1)
    s(x - 1)(y - 1) = "+"

    while (q.nonEmpty) {
        val (nowX, nowY) = q.dequeue()

        for (i <- 0 until 4) {
            val nextX = nowX + dx(i)
            val nextY = nowY + dy(i)

            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= m) {

            } else if (s(nextX)(nextY) == "#" || s(nextX)(nextY) == "+") {

            } else {
                s(nextX)(nextY) = "+"
                q.enqueue((nextX, nextY))
            }
        }
    }
    for (i <- 0 until n) {
        println(s(i).mkString(""))
    }
}
//解答例使用済み