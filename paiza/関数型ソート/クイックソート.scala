import scala.io.StdIn._

object Main extends App {

    val list = readLine().trim().split(" ").toList.map(_.toInt)

    def quickSort[T](less: (T, T) => Boolean)(list: List[T]): List[T] = {
        list match {
            case Nil => Nil
            case pivot :: tail =>
            val (smaller, greater) = tail.partition(less(_, pivot))
            quickSort(less)(smaller) ::: pivot :: quickSort(less)(greater)
        }
    }
    val descendingOrder = quickSort((x: Int, y: Int) => x > y)(list)
    val ascendingOrder = quickSort((x: Int, y: Int) => x < y)(list)
    println(descendingOrder.mkString(" "))
    println(ascendingOrder.mkString(" "))
}

//サンプルコード