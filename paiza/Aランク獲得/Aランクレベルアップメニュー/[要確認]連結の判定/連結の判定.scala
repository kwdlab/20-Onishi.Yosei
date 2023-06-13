import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {
    val Array(n, m) = readLine().split(" ").map(_.toInt)

    val color = Array.fill(n)(0)
    val graph = Array.fill[List[Int]](n)(Nil)
    val Q = Queue[Int]()

    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        val ai = a - 1
        val bi = b - 1
        graph(ai) = bi :: graph(ai)
        graph(bi) = ai :: graph(bi)
    }

    Q.enqueue(0)
    color(0) = 1

    while (Q.nonEmpty) {
        val now = Q.dequeue()
        for (i <- graph(now)) {
            if (color(i) == 0) {
                color(i) = 1
                Q.enqueue(i)
            }
        }
    }

    if (color.exists(_ == 0)) {
        println("NO")
    } else {
        println("YES")
    }
}

//解答例使用済み