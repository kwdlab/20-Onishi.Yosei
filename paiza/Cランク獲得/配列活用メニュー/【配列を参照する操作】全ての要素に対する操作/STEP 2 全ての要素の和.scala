import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.ofDim[Int](n)
    
    for (i <- 0 until n){
        a(i) = readLine().trim().toInt
    }
    println(a.sum)
}