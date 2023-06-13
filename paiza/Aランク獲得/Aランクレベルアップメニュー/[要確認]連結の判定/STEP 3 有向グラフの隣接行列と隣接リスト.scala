import scala.io.StdIn._

object Main extends App {

    val NM = readLine().split(" ").map(_.toInt)
    val N = NM(0)
    val M = NM(1)
    val g = Array.ofDim[Int](N, N)
    val G = Array.fill[List[Int]](N)(Nil)

    for (_ <- 0 until M) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        val aIdx = a - 1
        val bIdx = b - 1
        g(aIdx)(bIdx) = 1
        G(aIdx) = bIdx :: G(aIdx)
    }

    for (i <- 0 until N) {
        for (j <- 0 until N) {
            print(g(i)(j))
        }
        println()
    }

    for (line <- G) {
        val sortedLine = line.sorted
        sortedLine.foreach(print)
        println()
    }
}

//解答例使用済み