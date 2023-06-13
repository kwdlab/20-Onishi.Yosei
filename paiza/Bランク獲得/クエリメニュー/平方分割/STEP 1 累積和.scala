import scala.io.StdIn._

object Main extends App {

    val NK = readLine().split(" ").map(_.toInt)
    val N = NK(0)
    val K = NK(1)
    val An = Array.ofDim[Int](N)

    for(i <- 0 until N){
        val tmp = readLine().toInt
        if (i == 0){
            An(i) = tmp
        } else {
            An(i) = An(i-1) + tmp
        }
    }
    for(i <- 0 until K){
        val index = readLine().toInt
        println(An(index-1))
    }
}
