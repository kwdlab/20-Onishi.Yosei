import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Q = readLine().toInt
    val A = Queue[Int]()

    for (_ <- 0 until Q){
        val line = readLine().split(" ")
        if (line(0) == "1"){
            A.enqueue(line(1).toInt)
        }
    }

    println(A.length)
    while (A.nonEmpty){
        println(A.dequeue())
    }
}