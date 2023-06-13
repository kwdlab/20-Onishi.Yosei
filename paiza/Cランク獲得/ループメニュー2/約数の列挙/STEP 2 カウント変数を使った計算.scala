import scala.io.StdIn._

object Main extends App {

    val num = readLine().toInt
    val Mline = readLine().split(" ")

    for (i <- 0 until num){
        println(Mline(i).toInt * (i+1))
    }
}
