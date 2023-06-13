import scala.io.StdIn._

object Main extends App {
     
    val nab = readLine().split(" ")
    val n = nab(0).toInt
    val a = nab(1).toInt
    val b = nab(2).toInt
    var dp = Array.ofDim[Int](n+1)
        
    dp(0) = 1

    for (i <- 1 to n){
        dp(i) = 0
        if (i >= a){
            dp(i) = dp(i) + dp(i-a)
        }
        if (i >= b){
            dp(i) = dp(i) + dp(i-b)
        }
    }
    println(dp(n))
}
