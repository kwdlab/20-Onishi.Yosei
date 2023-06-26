import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = Array.fill[Int](n, n+1)(0)

    for (i <- 0 until n){
        matrix(i)(n) = i+1
    }
    
    for (i <- 1 until n){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        matrix(a-1)(b-1) = 1
        matrix(b-1)(a-1) = 1
    }

    def countTriangle(n: Int, mat: Array[Array[Int]], sum: Int): Int = {
        val count = mat(n).dropRight(1).count(_ == 1)
        val result = (count * (count-1)) / 2

        if (mat.length > n+1) {
            return countTriangle(n+1, mat, sum+result)
        } else {
            return sum+result
        } 
    }

    if (countTriangle(0, matrix, 0) % 2 == 0){
        println("erik")
    } else {
        println("paiza")
    }
}
