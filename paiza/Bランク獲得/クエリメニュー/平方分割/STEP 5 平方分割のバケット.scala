import scala.io.StdIn._

object Main extends App {

    val A = Array.ofDim[Int](100, 100)
    for (i <- 0 until 100; j <- 0 until 100){
        A(i)(j) = readLine().toInt
    }
    for (i <- A){
        println(i.max)
    }
}
