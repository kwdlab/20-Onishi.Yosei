import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val A = readLine().trim().split(" ").map(_.toInt)

    def insertionSort(a: Array[Int], n: Int, i: Int): Unit = {
        if (i < n) {
            val key = a(i)

            def innerJ(j: Int): Unit = {
                if (j >= 0 && a(j) > key) {
                    a(j + 1) = a(j)
                    innerJ(j-1)
                } else {
                    a(j + 1) = key
                    println(a.mkString(" "))
                }
            }
            innerJ(i-1)
            insertionSort(a, n, i + 1)
        } else {
            return
        }
    }
    insertionSort(A, n, 1)
}