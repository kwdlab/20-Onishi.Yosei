import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val t = readLine().split(" ").map(_.toInt)

    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) ::= b
        graph(b) ::= a
    }

    val q = Queue[Int](0)
    val dist = Array.fill(n)(-1)
    dist(0) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()

        for (next <- graph(now)){
            if (dist(next) == -1){
                dist(next) = dist(now) + 1
                q.enqueue(next)
            }
        }
    }
    val ans = (0 until n).foldLeft(0) { case (tmp, i) => 
        if (5 * dist(i) < t(i)) tmp+1
        else tmp
    }
    println(ans)
}
//解答例使用済み