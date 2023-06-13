import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine.trim().split(" ").map(_.toInt)
    val a = Array.ofDim[Int](n)
    
    for (i <- 0 until n){
        a(i) = readLine().trim().toInt
    }

    if (a.count(_ == k) > 0){
        println("Yes")
    } else {
        println("No")
    }
}