import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Queue

object Main extends App {

    def bfs(s: Int, g: Array[ArrayBuffer[Int]]): Array[Int] = {
        val dist = Array.fill(n)(-1)
        dist(s) = 0
        val q = Queue(s)

        while (q.nonEmpty) {
            val now = q.dequeue()
            for (nxt <- g(now)) {
                if (dist(nxt) == -1) {
                    dist(nxt) = dist(now) + 1
                    q.enqueue(nxt)
                }
            }
        }
        dist
    }

    val n = readLine().toInt
    val g = Array.fill(n)(ArrayBuffer.empty[Int])

    for (_ <- 1 until n) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g(a - 1).append(b - 1)
        g(b - 1).append(a - 1)
    }

    def printOut():Unit = {
        val distFromZero = bfs(0, g)
        val maxDist = distFromZero.max

        for ((dist, i) <- distFromZero.zipWithIndex) {
            if (dist == maxDist) {
                val diameter = bfs(i, g).max
                println(diameter)
                return
            }
        }        
    }
    printOut()
}

//解答例使用済み