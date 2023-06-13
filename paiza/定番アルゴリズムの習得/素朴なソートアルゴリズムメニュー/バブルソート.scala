import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)

    def bubbleSort(A: Array[Int], n: Int) = {
        for (i <- 0 until n-1){
            for (j <- n-1 until i by -1){
                if(A(j-1) > A(j)){
                    swap(j-1, j)
                }
            }
            println(A.mkString(" "))
        }
        def swap(i: Int, j: Int) = {
            var tmp = A(i)
            A(i) = A(j)
            A(j) = tmp
        }
    }

    bubbleSort(An, n)
}
