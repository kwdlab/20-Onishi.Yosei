import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)

    def selectionSort(A: Array[Int], n: Int) = {
        for (i <- 0 until n-1){
            var minI = i

            for (j <- i+1 until n){
                if(A(j) < A(minI)){
                    minI = j
                }
            }
            swap(i, minI)
            println(A.mkString(" "))
        }
        def swap(i: Int, j: Int) = {
            var tmp = A(i)
            A(i) = A(j)
            A(j) = tmp
        }
    }

    selectionSort(An, n)
}
