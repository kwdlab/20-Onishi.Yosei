import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().split(" ").map(_.toInt)
    val result = Array.ofDim[Int](10)

    for (i <- 0 until 10){
        result(i) = a.count(x => x == i)
    }
    println(result.mkString(" "))
}
