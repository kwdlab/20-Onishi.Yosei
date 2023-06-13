import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val Aline = readLine().split(" ").map(_.toInt)
    val Bline = readLine().split(" ").map(_.toInt)
    
    val rLine = (Aline ++ Bline).distinct.sorted
    println(rLine.mkString(" "))
}
