import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)
    val k = readLine().toInt
    
    println(an.filter(_ <= k).max)
}
