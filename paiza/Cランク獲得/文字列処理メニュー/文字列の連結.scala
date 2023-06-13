import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    var Sline = Array.ofDim[String](num)

    for (i <- 0 until num){
        Sline(i) = readLine()
    }

    println(Sline.mkString(""))
}