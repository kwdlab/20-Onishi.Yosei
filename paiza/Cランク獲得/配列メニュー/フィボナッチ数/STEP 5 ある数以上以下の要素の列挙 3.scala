import scala.io.StdIn._
import Math._

object Main extends App {

    val num = readLine().toInt
    val line = readLine().split(" ").map(_.toInt)
    val sum = line.sum.toFloat
    val ave = (sum/num).toFloat

    for (i <- line){
        if (i >= ave){
            println(i)
        }
    }
}
