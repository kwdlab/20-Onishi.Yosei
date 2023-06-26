import scala.io.StdIn._

object Main extends App {

    val N = readLine().trim().toInt
    val An = Array.ofDim[Long](N)

    for (i <- 0 until N){
        An(i) = readLine().trim().toLong
    }
    
    def GCD(x: Long, y: Long): Long = {
        if (y == 0){ return x }
        else { return GCD(y, x%y) }
    }
    
    var result = An(0)
    for (i <- 1 until N){
        result = GCD(result, An(i))
    }
    println(result)
}