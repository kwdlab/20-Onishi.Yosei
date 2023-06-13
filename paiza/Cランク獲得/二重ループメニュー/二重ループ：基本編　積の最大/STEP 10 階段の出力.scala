import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt

    val result: Array[Array[Int]] = (1 to n).foldLeft(Array.empty[Array[Int]]) { (array, i) =>
        array :+ (1 to i).toArray
    }

    for (i <- result){
        println(i.mkString(" "))
    }
}