import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine.trim().split(" ").map(_.toInt)
    val a = Array.ofDim[Int](n)
    
    for (i <- 0 until n){
        a(i) = readLine().trim().toInt
    }
    if (a.indexOf(k) != -1){
        println(a.indexOf(k) + 1)
    } else {
        println(-1)
    }
}