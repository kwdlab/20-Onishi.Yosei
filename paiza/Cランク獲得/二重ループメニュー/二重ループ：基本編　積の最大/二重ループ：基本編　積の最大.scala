import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)

    val a = readLine().split(" ").map(_.toInt)
    val b = readLine().split(" ").map(_.toInt)

    val tmp = a.flatMap(i => b.map(j => i * j)).max
    println(tmp)
}