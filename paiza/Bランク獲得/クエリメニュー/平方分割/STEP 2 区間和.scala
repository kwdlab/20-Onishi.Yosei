import scala.io.StdIn._

object Main extends App {

    val NK = readLine().split(" ").map(_.toInt)
    val N = NK(0)
    val K = NK(1)
    val An = Array.ofDim[Int](N+1)

    for(i <- 1 to N){
        val tmp = readLine().toInt
        An(i) = An(i-1) + tmp
    }

    for(i <- 0 until K){
        val lr = readLine().split(" ").map(_.toInt)
        val start = lr(0)
        val end = lr(1)
        println(An(end) - An(start-1))
    }
}
