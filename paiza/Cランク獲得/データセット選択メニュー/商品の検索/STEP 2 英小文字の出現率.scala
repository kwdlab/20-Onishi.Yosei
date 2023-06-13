import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = readLine().trim()

    val result: Array[String] = ('a' to 'z').foldLeft(Array.empty[String]) { (array, i) =>
        array :+ s.count(x => x == i).toString
    }

    println(result.mkString(" "))
}