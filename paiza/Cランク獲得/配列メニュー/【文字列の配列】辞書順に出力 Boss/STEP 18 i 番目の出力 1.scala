import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val line = Array("good", "morning", "paiza", "813", "pa13")

    println(line(num-1))
}
