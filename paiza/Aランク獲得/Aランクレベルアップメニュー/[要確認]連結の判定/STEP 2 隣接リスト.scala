import scala.io.StdIn._

object Main extends App {

    val NM = readLine().split(" ").map(_.toInt)
    val N = NM(0)
    val M = NM(1)
    val g = Array.fill[List[Int]](N)(Nil)

    for (_ <- 0 until M) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        val aIdx = a - 1
        val bIdx = b - 1
        g(aIdx) = bIdx :: g(aIdx)
        g(bIdx) = aIdx :: g(bIdx)
    }

    for (line <- g) {
        val sortedLine = line.sorted
        sortedLine.foreach(print)
        println()
    }
}

//解答例使用済み