import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val N = readLine().toInt
    var sum = 0
    val graph = Array.fill[List[Int]](N)(Nil)
    val visit = Queue[Int]()
    val done = Array.ofDim[Int](N)
    val apples = Array.ofDim[Int](N)

    for (_ <- 0 until N - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        val ai = a - 1
        val bi = b - 1
        graph(ai) = bi :: graph(ai)
        graph(bi) = ai :: graph(bi)
    }

    for (i <- 0 until N) {
        apples(i) = readLine().toInt
    }

    visit.enqueue(0)
    done(0) = 1
    sum = sum + apples(0)

    while (visit.nonEmpty) {
        println(sum)
        val now = visit.dequeue()
        for (j <- graph(now)) {
            if (done(j) == 0) {
                visit.enqueue(j)
                done(j) = 1
                sum = sum + apples(j)
            }
        }
    }
}

//解答例使用済み