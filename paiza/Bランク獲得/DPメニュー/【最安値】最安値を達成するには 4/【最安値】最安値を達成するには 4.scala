import scala.io.StdIn._

object Main extends App {
     
    val Array(n, x, a, y, b, z, c) = readLine().split(" ").map(_.toInt)
    val dp = Array.fill[Int](n+z)(100000000)

    dp(0) = 0
    for (i <- x to n+z-1){
        if (i >= x){
            dp(i) = Array(dp(i), dp(i-x) + a).min
        }
        if (i >= y){
            dp(i) = Array(dp(i), dp(i-y) + b).min   
        }
        if (i >= z){
            dp(i) = Array(dp(i), dp(i-z) + c).min
        }
    }
    for (i <- 1 to n){
        val tmp = Array.ofDim[Int](z)
        for (j <- 0 until z){
            tmp(j) = dp(i+j)
        }
        dp(i) = tmp.min
    }
    println(dp(n))
}
