import scala.io.StdIn._

object Main extends App {
    
    val nx = readLine().split(" ").map(_.toInt)
    val n = nx(0)
    val x = nx(1)
    val An = Array.ofDim[Int](n)
    val dp = Array.ofDim[Boolean](x+1)

    for(i <- 0 until n){
        An(i) = readLine().toInt
    }

    for (i <- 0 to x){
        dp(i) = false
    }
    dp(0) = true

    for (i <- An; j <- x to i by -1){
        if (dp(j-i)){
            dp(j) = true
        }
    }
    if (dp(x)){ println("yes")}
    else { println("no")}
}
