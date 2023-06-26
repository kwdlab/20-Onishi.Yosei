import scala.io.StdIn._
import scala.collection.mutable.Queue
object Main extends App {

    val Array(n, m, x, y) = readLine().split(" ").map(_.toInt)
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
    val count = Array.fill(n)(-1)
    count(x - 1) = 0
    
    while (q.nonEmpty) {
        val now = q.dequeue()
        for (nxt <- graph(now)) {
            if (count(nxt) == -1) {
                count(nxt) = count(now) + 1
                q.enqueue(nxt)
            }
        }
    }
    println(count(y-1))
}   
//解答例使用済み