import scala.io.StdIn._

object Main extends App {
    
    val nx = readLine().split(" ").map(_.toInt)
    val n = nx(0)
    val x = nx(1)
    val An = Array.ofDim[Int](n)
    val dp = Array.ofDim[Int](x+1)

    for(i <- 0 until n){
        An(i) = readLine().toInt
    }

    for (i <- 0 to x){
        dp(i) = n+1
    }
    dp(0) = 0

    for (i <- An; j <- x to i by -1){
        if (dp(j-i) != n + 1){
            dp(j) = Array(dp(j), dp(j-i) + 1).min
        }
      }

    if (dp(x) == n + 1) {
        println(-1)
    } else {
        println(dp(x))
    }
}
