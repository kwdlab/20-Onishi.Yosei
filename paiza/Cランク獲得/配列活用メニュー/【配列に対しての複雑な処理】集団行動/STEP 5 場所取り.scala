import scala.io.StdIn._

object Main extends App {

    val Array(n, k, f) = readLine().split(" ").map(_.toInt)
    val a = Array.ofDim[Int](k)

    for (i <- 0 until k){
        a(i) = readLine().toInt
    }

    val result = a.drop(f).distinct
    result.foreach(println)
}