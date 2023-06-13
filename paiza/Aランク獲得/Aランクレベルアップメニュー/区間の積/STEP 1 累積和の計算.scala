import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val An = readLine.split(" ").map(_.toInt)
    val result = Array.ofDim[Int](N+1)

    result(0) = 0
    for (i <- 1 to N){
        result(i) = result(i-1) + An(i-1)
        println(result(i))
    }

}
