import scala.io.StdIn._

object Main extends App {
     
    val nab = readLine().split(" ")
    val n = nab(0).toInt
    val a = nab(1).toInt
    val b = nab(2).toInt
    val dp = Array.ofDim[Int](n+1)
        
    dp(0) = 0
    dp(1) = a

    for (i <- 2 to n){
        dp(i) = 0
        dp(i) = Array(dp(i-1) + a, dp(i-2) + b).min
    }
    println(dp(n))
}
