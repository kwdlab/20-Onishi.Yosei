import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val line = Array.fill(n)(readLine().split(" "))

    for (i <- line){
        println(i.mkString(" "))
    }
}