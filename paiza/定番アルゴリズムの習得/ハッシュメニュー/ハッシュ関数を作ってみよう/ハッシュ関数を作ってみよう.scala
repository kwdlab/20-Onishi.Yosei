import scala.io.StdIn._

object Main extends App {

    val Array(n) = readLine().split(" ").map(_.toInt)

    for (_ <- 0 until n) {
        val x = readLine().split("")
        val result = ('a' to 'z').zip(1 to 26).foldLeft(Array.empty[Int]) { case (acc, (char, index)) =>
            val charCount = x.count(_ == char)
            val tmp = charCount * x.indexOf(char.toString) * index
            acc :+ tmp
        }
        println(result.sum % 100)
    }
}