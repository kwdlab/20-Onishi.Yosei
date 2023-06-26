import scala.io.StdIn._

object Main extends App {

    val line = readLine().trim().split(" ").toList.map(_.toInt)

    @scala.annotation.tailrec
    def bubbleSort[T](less: (T, T) => Boolean)(xs: List[T], n: Int): List[T] = {
        if (n <= 1) xs
        else {
            val swappedList = (0 until n-1).foldLeft(xs) { (tmp, i) =>
                if (less(tmp(i+1), tmp(i))) tmp.updated(i, tmp(i+1)).updated(i+1, tmp(i))
                else tmp
            }
            bubbleSort(less)(swappedList, n-1)
        }
    }

    val descendingOrder = bubbleSort((x: Int, y: Int) => x > y)(line, line.length)
    val ascendingOrder = bubbleSort((x: Int, y: Int) => x < y)(line, line.length)
    println(descendingOrder.mkString(" "))
    println(ascendingOrder.mkString(" "))
}