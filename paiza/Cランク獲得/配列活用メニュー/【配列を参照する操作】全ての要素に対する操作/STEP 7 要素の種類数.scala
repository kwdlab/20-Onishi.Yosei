import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = Array.ofDim[Int](n)

    for (i <- 0 until n){
        a(i) = readLine().toInt
    }
    println(a.toSet.toList.length)
}