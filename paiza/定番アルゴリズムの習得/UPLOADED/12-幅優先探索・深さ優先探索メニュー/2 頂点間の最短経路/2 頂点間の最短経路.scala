import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x, y) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    val distance = Array.fill(n)(-1)
    val route = Array.fill(n)(List.empty[Int])
    distance(x - 1) = 0
    route(x - 1) = x - 1 :: route(x - 1)
    val q = Queue[Int](x - 1)
    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- graph(now)) {
            if (distance(nxt) == -1) {
                distance(nxt) = distance(now) + 1
                route(nxt) = nxt :: route(now)
                q.enqueue(nxt)
            }
        }
    }
    route(y-1).reverse.foreach(x => println(x+1))
}