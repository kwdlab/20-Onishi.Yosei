import scala.io.StdIn._

object Main extends App {
    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val a = readLine().split(" ").map(_.toInt)

    for (_ <- 0 until q) {
        val Array(query, k, x) = readLine().split(" ")
        val index = k.toInt - 1
        val data = x.toInt
        query match {
            case "get" => {
                val Asorted = a.sorted.reverse
                println(Asorted(index))
            }

            case "update" => {
                a(index) = data
            }
        }
    }
}