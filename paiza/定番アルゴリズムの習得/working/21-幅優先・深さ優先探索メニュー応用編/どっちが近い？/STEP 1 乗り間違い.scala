import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, tmpx, tmpy) = readLine().split(" ").map(_.toInt)
    val x = tmpx - 1
    val y = tmpy - 1

    val graph = Array.fill(n)(List.empty[Int])
    val degree = Array.fill(n)(0)
    for (_ <- 0 until n - 1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        graph(a - 1) ::= b - 1
        graph(b - 1) ::= a - 1
        degree(a - 1) += 1
        degree(b - 1) += 1 
    }

    val q = Queue[Int]()
    q.enqueue(x)
    val dist = Array.fill(n)(-1)
    dist(x) = 0

    while (q.nonEmpty) {
        val now = q.dequeue()

        for (next <- graph(now)){
            if (dist(next) == -1){
                dist(next) = dist(now) + 1
                q.enqueue(next)
            }
        }
    }
    if (degree(x) < 2){
        println(dist(y) * 5)
    } else {
        println(10 + dist(y) * 5)
    }
}

//解答例使用済み