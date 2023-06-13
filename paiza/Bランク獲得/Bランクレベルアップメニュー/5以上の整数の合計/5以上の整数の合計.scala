import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val alist = Array.ofDim[Int](n)

    for (i <- 0 until n){
        alist(i) = readLine().toInt
    }
    println(alist.filter(x => x >= 5).sum)
}
