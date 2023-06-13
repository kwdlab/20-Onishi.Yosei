import scala.io.StdIn._

object Main extends App {

    val S = readLine().toArray
    val line = readLine().split(" ")
    val i = line(0).toInt
    val j = line(1).toInt

    val result = S.drop(i-1).take(j-i+1)
    println(result.mkString(""))
}