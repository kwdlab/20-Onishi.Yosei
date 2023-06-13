import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val A = readLine().trim().split(" ").map(_.toInt)

    def bubbleSort(a: Array[Int], n: Int) = {
        def innerIJ(i: Int, j: Int):Unit = {
            if (i == n-1) {
                return
            } else if (j == i) {
                println(a.mkString(" "))
                innerIJ(i+1, n-1)

            } else if (i < n-1 && i < j){
                if (a(j-1) > a(j)){
                    swap(j-1, j)
                }
                innerIJ(i, j-1)
            }
        }
        def swap(x: Int, y: Int) = {
            val tmp = a(x)
            a(x) = a(y)
            a(y) = tmp
        }
        innerIJ(0, n-1)
    }
    bubbleSort(A, n)
}