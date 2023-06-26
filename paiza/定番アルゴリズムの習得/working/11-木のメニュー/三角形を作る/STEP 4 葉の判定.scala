import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = Array.fill[Int](n, n)(0)
    
    for (i <- 1 until n){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        matrix(a-1)(b-1) = 1
        matrix(b-1)(a-1) = 1
    }

    def printLeafnode(count: Int, n: Int, mat: Array[Array[Int]]): Unit = {
        if (count < n){
            if (mat(count).sum == 1){
                println(count+1)
            }
            printLeafnode(count+1, n, mat)
        }
    }

    printLeafnode(0, n, matrix)
}