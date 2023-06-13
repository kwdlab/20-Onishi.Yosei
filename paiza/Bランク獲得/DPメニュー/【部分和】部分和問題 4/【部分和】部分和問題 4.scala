import scala.io.StdIn._

object Main extends App {
    
    val nx = readLine().split(" ").map(_.toInt)
    val n = nx(0)
    val x = nx(1)
    val An = Array.ofDim[Int](n)

    for(i <- 0 until n){
        An(i) = readLine().toInt
    }

    def canAchieve(list: Array[Int], x: Int): Boolean = {
        val dp = Array.ofDim[Boolean](x+1)
        dp(0) = true

        for (i <- 1 to x; j <- An) {
            if (i - j >= 0 && dp(i - j)) {
                dp(i) = true
            }
        }
        return dp(x)
    }

    if (canAchieve(An, x)){ println("yes")}
    else { println("no")}
}
