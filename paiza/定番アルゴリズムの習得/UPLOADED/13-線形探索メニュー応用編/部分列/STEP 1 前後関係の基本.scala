import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)

    val line = an.sliding(2).toList
    println(line.count{ case Array(prev, next) => prev == next })
}
