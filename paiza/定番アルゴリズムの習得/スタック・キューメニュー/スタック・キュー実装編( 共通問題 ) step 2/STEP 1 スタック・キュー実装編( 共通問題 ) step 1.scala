import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val n = readLine().toInt
    val A = Queue[Int]()
    
    A.enqueue(n)
    for (_ <- 0 until n){
        A.enqueue(readLine().toInt)
    }
    while (A.nonEmpty){
        println(A.dequeue())
    }
}