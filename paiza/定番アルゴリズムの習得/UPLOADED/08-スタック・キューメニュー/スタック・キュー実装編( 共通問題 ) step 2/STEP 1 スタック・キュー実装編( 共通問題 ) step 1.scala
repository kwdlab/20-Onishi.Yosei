import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val n = readLine().toInt
    val queue = Queue[Int]()
    
    queue.enqueue(n)
    for (_ <- 0 until n){
        queue.enqueue(readLine().toInt)
    }
    while (queue.nonEmpty){
        println(queue.dequeue())
    }
}