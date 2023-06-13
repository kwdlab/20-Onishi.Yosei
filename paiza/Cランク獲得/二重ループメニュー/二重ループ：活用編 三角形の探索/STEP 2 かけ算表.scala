import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)
    val b = Array.ofDim[Int](n, n)

    for (i <-0 until n; j <- 0 until n){
        b(i)(j) = a(i)*a(j)
    }

    for(i <- b){
        println(i.mkString(" "))
    }
}