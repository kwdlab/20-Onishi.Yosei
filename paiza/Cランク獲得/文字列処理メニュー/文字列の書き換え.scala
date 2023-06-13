import scala.io.StdIn._

object Main extends App {

    val S = readLine().toArray
    val line = readLine().split(" ")
    val i = line(0).toInt
    val c = line(1)

    val result = S.take(i-1) ++ Array(c) ++ S.drop(i)
    println(result.mkString(""))
}