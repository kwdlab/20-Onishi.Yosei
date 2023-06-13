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
        if (An(i-1) <= An(i)){
            dp(i) = dp(i-1) + 1
        } else {
            dp(i) = 1
        }
    }

    println(dp.max)
}
