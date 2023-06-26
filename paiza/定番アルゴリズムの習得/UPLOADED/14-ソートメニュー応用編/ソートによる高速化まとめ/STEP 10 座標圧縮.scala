import scala.io.StdIn._

object Main extends App {
    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)
    val x = readLine().split(" ").map(_.toInt)

    val compressed = a.sorted.zipWithIndex.map { case (a_i, i) => a_i -> (i + 1) }.toMap

    for (i <- x) {
        println(compressed(i))
    }
}
//解答例使用済み