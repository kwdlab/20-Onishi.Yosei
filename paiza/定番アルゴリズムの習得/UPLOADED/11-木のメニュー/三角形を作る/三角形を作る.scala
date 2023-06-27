import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = makeAdjacencyMatrix(n)    

    def makeAdjacencyMatrix(n: Int): Array[Array[Int]] = {
        val matrix = Array.fill[Int](n, n+1)(0)
        for (i <- 0 until n){
            matrix(i)(n) = i+1
        }
        for (_ <- 0 until n-1){
            val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
            matrix(a)(b) = 1
            matrix(b)(a) = 1
        }
        matrix
    }
    @scala.annotation.tailrec
    def countTriangle(n: Int, mat: Array[Array[Int]], sum: Int): Int = {
        val count = mat(n).dropRight(1).count(_ == 1)
        val result = (count * (count-1)) / 2

        if (mat.length > n+1) countTriangle(n+1, mat, sum+result)
        else sum+result 
    }

    if (countTriangle(0, matrix, 0) % 2 == 0) println("erik")
    else println("paiza")
}
