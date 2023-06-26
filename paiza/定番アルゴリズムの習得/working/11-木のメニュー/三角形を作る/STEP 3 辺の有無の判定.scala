import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val matrix = Array.fill[Int](n, n)(0)
    
    for (i <- 1 until n){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        matrix(a-1)(b-1) = 1
        matrix(b-1)(a-1) = 1
    }

    for (i <- 0 until k){
        val Array(qa, qb) = readLine().split(" ").map(_.toInt)
        if (matrix(qa-1)(qb-1) == 1){
            println("YES")
        } else {
            println("NO")
        }
    }
}