import scala.io.StdIn._

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    graph(x-1).sorted.foreach(x => println(x+1))
}
