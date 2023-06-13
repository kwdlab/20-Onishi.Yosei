import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val t = readLine().split(" ").map(_.toInt)

    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
    }

    val q = Queue[Int]()
    q.enqueue(0)
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
    var ans = 0
    for (i <- 0 until n){
        if (5 * dist(i) < t(i)){
            ans += 1
        }
    }
    println(ans)
}

//解答例使用済み