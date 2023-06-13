import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt 
    val a = Array.fill(n)(readLine().trim().length)

    a.foreach(println)
}
