import scala.io.StdIn._

object Main extends App {

    val NK = readLine().split(" ").map(_.toInt)
    val N = NK(0)
    val K = NK(1)
    val P = Array.ofDim[Int](N)
    val eat = Array.ofDim[Int](N)

    for (i <- 0 until N){
        P(i) = readLine().toInt
    }

    for (i <- 0 until N){
        val tmp = Array.ofDim[Int](K)
        for (j <- 0 until K){
            if (i+j >= N) {
                tmp(j) = P(i+j-N)
            } else {
                tmp(j) = P(i+j) 
            }
        }
        eat(i) = tmp.sum
    }

    println(eat.max)
}