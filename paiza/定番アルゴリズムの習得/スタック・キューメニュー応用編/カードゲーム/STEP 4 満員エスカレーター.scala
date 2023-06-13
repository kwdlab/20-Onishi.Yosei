import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val Q = Queue[Int]()

    for (_ <- 0 until n){
        val q = readLine().split(" ")
        q(0) match {
            case "ride" => {
                for (i <- 0 until q(1).toInt){
                    if (Q.sum + q(i+2).toInt <= x){
                        Q.enqueue(q(i+2).toInt)
                    }
                }
            }
            case "get_off" => {
                if (Q.length < q(1).toInt){
                    while (Q.nonEmpty){
                        Q.dequeue()
                    }
                } else {
                    for (i <- 0 until q(1).toInt){
                        Q.dequeue()
                    }
                }
            }
        }
    }

    println(Q.length)
    println(Q.sum)
}