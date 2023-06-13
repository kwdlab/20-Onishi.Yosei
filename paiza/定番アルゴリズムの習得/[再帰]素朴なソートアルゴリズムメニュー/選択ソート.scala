import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val A = readLine().trim().split(" ").map(_.toInt)

    def selectionSort(a: Array[Int], n: Int) = {
        def innerIJ(i: Int, j: Int, min: Int):Unit = {
            if (i == n-1) {
                return
            } else if (j == n) {
                swap(i, min)
                println(a.mkString(" "))
                innerIJ(i+1, i+1+1, i+1)
            } else {
                if (a(j) < a(min)){
                    innerIJ(i, j+1, j)
                } else {
                    innerIJ(i, j+1, min)
                }
            }
        }
        def swap(x: Int, y: Int) = {
            val tmp = a(x)
            a(x) = a(y)
            a(y) = tmp
        }
        innerIJ(0, 0+1, 0)
    }
    selectionSort(A, n)
}