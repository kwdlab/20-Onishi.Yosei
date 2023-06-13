import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val Q = readLine().toInt
    val A = Stack[Int]()

    for (_ <- 0 until Q){
        val line = readLine().split(" ")
        if (line(0) == "1"){
            A.push(line(1).toInt)
        } else {
            A.pop
        }
        println(A.reverse.mkString(" "))
    }
}