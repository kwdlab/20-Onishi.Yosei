import scala.io.StdIn._

object Main extends App {
     
    val n = readLine().toInt
    val dp = Array.ofDim[Int](41)
        
    dp(0) = 1

    for (i <- 1 to n){
        dp(i) = 0
        if (i >= 1){
            dp(i) = dp(i) + dp(i-1)
        }
        if (i >= 2){
            dp(i) = dp(i) + dp(i-2)
        }
    }
    println(dp(n))
}
