import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val line = Array.fill(n)(readLine().split(" "))

    for (i <- line){
        println(i.mkString(" "))
    }
}