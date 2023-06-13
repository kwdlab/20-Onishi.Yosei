import scala.io.StdIn._
import scala.collection.mutable.Queue

object Main extends App {

    val N = readLine().toInt
    val matrix = Array.fill(N)(Queue[Int]())
    
    for (i <- 1 until N){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        matrix(a-1).enqueue(b)
        matrix(b-1).enqueue(a)
    }

    for (i <- matrix){
        println(i.toList.sorted.mkString(" "))
    }
}