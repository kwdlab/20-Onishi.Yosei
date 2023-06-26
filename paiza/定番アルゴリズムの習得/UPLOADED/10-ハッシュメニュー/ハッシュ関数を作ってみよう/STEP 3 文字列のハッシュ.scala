import scala.io.StdIn._

object Main extends App {

    val Array(n) = readLine().split(" ").map(_.toInt)

    for (_ <- 0 until n) {
        val x = readLine().split("")
        println(x.count(_ == "p") + x.count(_ == "a") + x.count(_ == "i") + x.count(_ == "z"))
    }
}