import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val n = readLine().toInt
    val A = Queue[Int]()
    val B = Queue[Int]()
    val C = Queue[Int]()

    for (_ <- 0 until n){
        val i = readLine().split(" ")
        i(0) match {
            case "push" => i(1) match {
                case "1" => A.enqueue(i(2).toInt)
                case "2" => B.enqueue(i(2).toInt)
                case "3" => C.enqueue(i(2).toInt)
            }
            case "pop" => i(1) match {
                case "1" => A.dequeue()
                case "2" => B.dequeue()
                case "3" => C.dequeue()
            }
        }
    }
    while (A.nonEmpty){
        println(A.dequeue())
    }
    while (B.nonEmpty){
        println(B.dequeue())
    }
    while (C.nonEmpty){
        println(C.dequeue())
    }
}