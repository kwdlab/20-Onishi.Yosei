import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val An = readLine().split(" ").map(_.toInt).toSet
    val q = Queue.fill(k)(0)

    for (i <- 1 to An.max){
        q.dequeue()
        if (An.contains(i)){
            q.enqueue(1)
            println(q.count(_ == 1))
        } else {
            q.enqueue(0)
        }
    }
}
