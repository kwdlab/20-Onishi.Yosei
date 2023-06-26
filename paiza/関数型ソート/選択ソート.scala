import scala.io.StdIn._

object Main extends App {

    val line = readLine().trim().split(" ").toList.map(_.toInt)

    def selectionSort[T](less: (T, T) => Boolean)(xs: List[T], n: Int): List[T] = {
        if (n <= 1) {
            xs
        } else {
            val maxIndex = (1 until n).foldLeft(0) {
                case (tmp, i) => if (less(xs(tmp), xs(i))) i else tmp 
            }
            val next = xs.updated(maxIndex, xs(n - 1)).updated(n - 1, xs(maxIndex))
            selectionSort(less)(next, n-1)
        }
    }

    val descendingOrder = selectionSort((x: Int, y: Int) => x > y)(line, line.length)
    val ascendingOrder = selectionSort((x: Int, y: Int) => x < y)(line, line.length)
    println(descendingOrder.mkString(" "))
    println(ascendingOrder.mkString(" "))
}