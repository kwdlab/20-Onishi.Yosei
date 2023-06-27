import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = Array.fill[Int](n, n)(0)
    
    for (_ <- 0 until n-1){
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        matrix(a)(b) = 1
        matrix(b)(a) = 1
    }

    @scala.annotation.tailrec
    def printLeafNode(count: Int, n: Int, matrix: Array[Array[Int]]): Unit = {
        if (count < n){
            if (matrix(count).sum == 1) println(count+1)
            printLeafNode(count+1, n, matrix)
        }
    }

    printLeafNode(0, n, matrix)
}