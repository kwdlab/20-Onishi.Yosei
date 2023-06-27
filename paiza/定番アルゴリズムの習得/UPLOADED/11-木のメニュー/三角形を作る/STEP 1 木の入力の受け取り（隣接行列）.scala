import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = Array.fill[Int](n, n)(0)
    
    for (i <- 1 until n){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        matrix(a-1)(b-1) = 1
        matrix(b-1)(a-1) = 1
    }

    for (i <- matrix){
        println(i.mkString(" "))
    }
}