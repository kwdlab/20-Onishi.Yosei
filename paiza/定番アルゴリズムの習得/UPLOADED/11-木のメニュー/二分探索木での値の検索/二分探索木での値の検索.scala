import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val tmp = Queue[Int]()
    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)

    for (_ <- 1 until n) {
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        tmp.enqueue(a)
        tmp.enqueue(b)
    }

    val result = tmp.toSet
    for (_ <- 0 until k) {
        val q = readLine().trim().toInt
        if (result.contains(q)) println("Yes")
        else println("No")
    }
}