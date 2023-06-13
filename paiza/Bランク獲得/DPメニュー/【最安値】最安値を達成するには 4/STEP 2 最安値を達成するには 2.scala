import scala.io.StdIn._

object Main extends App {
     
    val Array(n, a, b) = readLine().split(" ").map(_.toInt)
    val dp = Array.ofDim[Int](n+5)
        
    dp(0) = 0
    dp(1) = a
    for (i <- 2 to n+4){
        dp(i) = Int.MaxValue
        if (i >= 2){
            dp(i) = Array(dp(i), dp(i-2) + a).min
        }
        if (i >= 5){
            dp(i) = Array(dp(i), dp(i-5) + b).min   
        }

    }
    for (i <- 1 to n){
        dp(i) = Array(dp(i), dp(i+1), dp(i+2), dp(i+3), dp(i+4)).min
    }
    println(dp(n))
}
