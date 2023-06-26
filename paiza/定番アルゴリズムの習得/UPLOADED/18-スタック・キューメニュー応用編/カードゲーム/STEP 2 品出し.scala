import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val n = readLine().trim().toInt
    val Q = Queue[Int]()

    for (_ <- 0 until n){
        val q = readLine().split(" ")
        q(0) match {
            case "add" => Q.enqueue(q(1).toInt)
            case "buy" => {
                for (i <- 0 until q(1).toInt){
                    Q.dequeue()
                }
            }
        }
    }

    while (Q.nonEmpty){
        println(Q.dequeue())
    }
}