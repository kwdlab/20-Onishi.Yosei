import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val matrix = Array.fill[Int](n, n)(0)
    
    for (_ <- 0 until n-1){
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        matrix(a)(b) = 1
        matrix(b)(a) = 1
    }

    for (i <- 0 until k){
        val Array(qa, qb) = readLine().split(" ").map(_.toInt - 1)
        if (matrix(qa)(qb) == 1) println("YES")
        else println("NO")
    }
}