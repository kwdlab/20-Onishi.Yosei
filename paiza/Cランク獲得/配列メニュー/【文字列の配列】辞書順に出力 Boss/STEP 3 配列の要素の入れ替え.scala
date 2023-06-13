import scala.io.StdIn._

object Main extends App {

    val Array(a, b, n) = readLine().trim().split(" ").map(_.toInt)
    val line = readLine().trim().split(" ").map(_.toInt)

    val tmp = line(a-1)
    line(a-1) = line(b-1)
    line(b-1) = tmp
    
    line.foreach(println)
}
