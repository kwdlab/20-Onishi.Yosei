import scala.io.StdIn._

object Main extends App {
    
    val n = readLine().toInt
    val An = Array.ofDim[Int](n+1)
    val dp = Array.ofDim[Int](n+1)

    An(0) = 0
    dp(0) = 0
    for(i <- 1 to n){
        An(i) = readLine().toInt
    }

    dp(1) = 1
    for (i <- 2 to n){
        dp(i) = 1
        for (j <- 1 to i-1){
            if (An(j) > An(i)){
                dp(i) = Array(dp(i), dp(j)+1).max
            }
        }
    }
    println(dp.max)
}
