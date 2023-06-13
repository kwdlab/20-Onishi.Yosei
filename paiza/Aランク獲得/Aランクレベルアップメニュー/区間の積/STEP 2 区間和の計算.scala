import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val An = readLine.split(" ").map(_.toLong)
    val plusAn = Array.ofDim[Long](N+1)
    val n = readLine().toInt

    plusAn(0) = 0
    for (i <- 1 to N){
        plusAn(i) = plusAn(i-1) + An(i-1)
    }

    for (_ <- 1 to n){
        val lu = readLine().split(" ").map(_.toInt)
        val l = lu(0)
        val u = lu(1)   

        println(plusAn(u+1)-plusAn(l))
    }
}
