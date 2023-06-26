import scala.io.StdIn._

object Main extends App {

    def operationShuffle(opList: Array[(Int, Int, Int)], n: Int): Int = {
        var cups = List.fill[Boolean](n)(false)
        cups = true :: cups.tail

        for ((op, x, y) <- opList) {
            val xIndex = x - 1
            val yIndex = y - 1
            if (op == 1) {
                if (cups(xIndex) != cups(yIndex)) {
                cups = cups.updated(xIndex, !cups(xIndex))
                cups = cups.updated(yIndex, !cups(yIndex))
                }
            } else if (op == 2) {
                val ball = cups(xIndex)
                val (start, end) = cups.splitAt(xIndex)
                val (left, right) = end.tail.splitAt(yIndex - xIndex - 1)
                cups = start ::: (ball :: (left ::: (ball :: right))) ::: end.lastOption.toList
            }
        }

        cups.indexOf(true) + 1
    }

    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val opList = Array.ofDim[(Int, Int, Int)](q)

    for (i <- 0 until q) {
        val Array(op, x, y) = readLine().split(" ").map(_.toInt)
        opList(i) = (op, x, y)
    }

    val result = operationShuffle(opList, n)
    println(result)
}
//解答例使用済み