import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val result = Array.ofDim[Int](n)

    for (i <- 0 until n){
        val line = readLine().split(" ").map(_.toInt)
        if (line(0) == line(1)){
            result(i) = line(0) * line(1)
        } else {
            result(i) = line(0) + line(1)
        }
    }
    println(result.sum)
}
