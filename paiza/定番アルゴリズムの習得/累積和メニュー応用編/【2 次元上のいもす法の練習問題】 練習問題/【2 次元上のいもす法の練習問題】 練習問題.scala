import scala.io.StdIn._

object Main extends App {

    val Array(n, q, m) = readLine().split(" ").map(_.toInt)
    val A = Array.ofDim[Int](n, n)
    val S = Array.ofDim[Int](n+m+1, n+m+1)

    for (i <- 0 until n){
        A(i) = readLine().split(" ").map(_.toInt)
    }

    for (i <- 0 until q){
        val Array(x, y) = readLine().split(" ").map(_.toInt)
        val updatedX = x - 1
        val updatedY = y - 1

        S(updatedY)(updatedX) += 1
        S(updatedY + m)(updatedX + m) += 1
        S(updatedY)(updatedX + m) -= 1
        S(updatedY + m)(updatedX) -= 1
    }

    for (i <- 0 until n + 1){
        for (j <- 0 until n + 1){
            if (j > 0){
                S(i)(j) += S(i)(j - 1)
            }
        }
    }

    for (i <- 0 until n + 1){
        for (j <- 0 until n + 1){
            if (i > 0){
                S(i)(j) += S(i - 1)(j)
            }
        }
    }

    var killCount = 0
    for (i <- 0 until n){
        for (j <- 0 until n){
            if (S(i)(j) >= A(i)(j)){
                killCount += 1
            }
        }
    }

    println(killCount)
}
//解答例使用済み