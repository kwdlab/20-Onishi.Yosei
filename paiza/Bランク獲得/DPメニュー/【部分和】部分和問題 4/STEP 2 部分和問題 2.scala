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
        dp(i) = 0
    }
    dp(0) = 1

    for (i <- An; j <- x to i by -1){
        dp(j) = dp(j) + dp(j-i)
        dp(j) = dp(j) % 1000000007
    }
    println(dp(x))
}
