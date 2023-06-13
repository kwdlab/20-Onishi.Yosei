import scala.io.StdIn._

object Main extends App {

    val Array(n, l, r) = readLine().split(" ").map(_.toInt)
    val An = readLine().split(" ").map(_.toInt)

    val sortedAnSlice = An.slice(l - 1, r - 1).sorted
    val result = An.take(l-1) ++ sortedAnSlice ++ An.drop(r-1)
    println(result.mkString(" "))
}