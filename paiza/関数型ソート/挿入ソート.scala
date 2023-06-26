import scala.io.StdIn._

object Main extends App {

    val line = readLine().trim().split(" ").toList.map(_.toInt)

    def insertionSort[T](less: (T, T) => Boolean)(xs: List[T]): List[T] = {
        def insert(x: T, xs: List[T]): List[T] = {
            if (xs.isEmpty || less(x, xs.head)) x :: xs
            else xs.head :: insert(x, xs.tail)
        }

        if (xs.isEmpty) Nil
        else insert(xs.head, insertionSort(less)(xs.tail))
    }

    val descendingOrder = insertionSort((x: Int, y: Int) => x > y)(line)
    val ascendingOrder = insertionSort((x: Int, y: Int) => x < y)(line)
    println(descendingOrder.mkString(" "))
    println(ascendingOrder.mkString(" "))
}

//サンプルコード