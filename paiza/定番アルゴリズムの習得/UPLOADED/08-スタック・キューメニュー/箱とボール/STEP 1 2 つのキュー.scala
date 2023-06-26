import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val Q = readLine().toInt
    val A = Queue[Int]()
    val B = Queue[Int]()

    for (_ <- 0 until Q){
        val i = readLine().split(" ")
        if (i(0) == "1"){
            if (i(1) == "1"){
                A.enqueue(i(2).toInt)
            } else {
                B.enqueue(i(2).toInt)
            }
        }
        else if (i(0) == "2"){
            if (i(1) == "1"){
                println(A.dequeue)
            } else {
                println(B.dequeue)
            }
        }
        else {
            println(s"${A.length} ${B.length}")
        }
    }
}