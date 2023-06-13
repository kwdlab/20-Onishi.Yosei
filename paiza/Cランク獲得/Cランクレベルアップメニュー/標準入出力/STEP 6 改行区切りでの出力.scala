import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = readLine().trim().split(" ").map(_.toInt)
    
    a.foreach(println)
}