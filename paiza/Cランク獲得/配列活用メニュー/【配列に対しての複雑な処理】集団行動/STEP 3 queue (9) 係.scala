import scala.io.StdIn._
import scala.collection.mutable.ArrayDeque

object Main extends App {

    val n = readLine().trim().toInt
    val s = Array.ofDim[String](n)
    val line = ArrayDeque[Int]()

    for (i <- 0 until n){
        s(i) = readLine().trim()
    }

    for (i <- 0 until n){
        if (s(i).length == 3){
            if (line.nonEmpty){
                line.removeHead()
            }
        } else {
            val tmp = s(i).split(" ")
            line.append(tmp(1).toInt) 
        }
    }
    line.foreach(println)
}