import scala.io.StdIn._
import scala.collection.mutable.Queue
object Main extends App {

    val Array(n, m, x) = readLine().split(" ").map(_.toInt)
    val graph = Array.fill(n)(Array.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) = graph(a - 1) ++ Array(b - 1)
        graph(b - 1) = graph(b - 1) ++ Array(a - 1)
    }
    for (i <- 0 until n){
        graph(i) = graph(i).sorted
    }

    val q = Queue[Int]()
    q.enqueue(x - 1)
    val unvisited = Array.fill(n)(true)
    unvisited(x - 1) = false
    
    while (q.nonEmpty) {
        val now = q.dequeue()
        println(now + 1)
        for (nxt <- graph(now)) {
            if (unvisited(nxt)) {
                unvisited(nxt) = false
                q.enqueue(nxt)
            }
        }
    }
}   
//解答例使用済み