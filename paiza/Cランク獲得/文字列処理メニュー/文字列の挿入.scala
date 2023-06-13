import scala.io.StdIn._

object Main extends App {

    val S = readLine().toArray
    val T = readLine().toArray
    val N = readLine().toInt

    val result = S.take(N) ++ T ++ S.drop(N)
    println(result.mkString(""))
}