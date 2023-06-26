import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val q = readLine().toInt
    val queue = Queue[Int]()

    for (_ <- 0 until q){
        val line = readLine().split(" ")
        if (line(0) == "1"){
            queue.enqueue(line(1).toInt)
        }
    }

    println(queue.length)
    while (queue.nonEmpty){
        println(queue.dequeue())
    }
}