import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val Aline = readLine().split(" ").map(_.toInt)
    
    val Rline = Aline.distinct.sorted
    println(Rline.mkString(" "))
}
