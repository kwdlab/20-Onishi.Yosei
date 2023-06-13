import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)

    def insertionSort(A: Array[Int], n: Int) = {
        for (i <- 1 until n){
            val x = A(i)
            var j = i - 1

            while (j >= 0 && A(j) > x){
                A(j+1) = A(j)
                j = j - 1
            }
            A(j+1) = x
            println(A.mkString(" "))
        }
    }

    insertionSort(An, n)
}
