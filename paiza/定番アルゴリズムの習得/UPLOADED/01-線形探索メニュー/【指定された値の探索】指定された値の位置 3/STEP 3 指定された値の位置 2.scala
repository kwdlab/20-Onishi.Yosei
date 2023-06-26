import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)
    val k = readLine().toInt

    if (an.count(_ == k) == 1) println(an.indexOf(k)+1)
    else if (an.count(_ == k) > 1) println(an.lastIndexOf(k)+1)
    else println(0)
}
