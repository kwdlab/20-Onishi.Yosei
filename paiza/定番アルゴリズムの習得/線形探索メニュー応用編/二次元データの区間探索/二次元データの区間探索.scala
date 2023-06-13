import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k, x) = readLine().split(" ").map(_.toInt)
    val anm = Array.ofDim[Int](n, m)

    for (i <- 0 until n){
        anm(i) = readLine().split(" ").map(_.toInt)
    }

    def countUp(N: Int, M: Int, K: Int, X: Int) = {
        var count = 0
        for (i <- 0 until N-K+1; j <- 0 until M-K+1){
            var sum = 0
            for (y <- 0 until K; x <- 0 until K){
                if (anm(i+y)(j+x) <= X){
                    sum = sum + 1
                }
            }
            if (sum == K*K){
                count = count + 1
            }
        }
        println(count)
    }
    countUp(n, m, k, x)
}
