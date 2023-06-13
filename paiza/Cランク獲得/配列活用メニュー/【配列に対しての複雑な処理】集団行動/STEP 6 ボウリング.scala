import scala.io.StdIn._

object Main extends App {

    val line710 = readLine().reverse
    val line46 = readLine().reverse
    val line23 = readLine().reverse
    val line1 = readLine()

    val AllLine = (s"${line1} ${line23} ${line46} ${line710}").split(" ").map(_.toInt)
    
    println(AllLine.indexOf(1) + 1)
    println(AllLine.count(_ == 1))
}