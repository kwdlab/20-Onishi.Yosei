import scala.io.StdIn._

object Main extends App {

    val Array(h, w, a, b) = readLine().trim().split(" ").map(_.toInt)
    val data = Array.fill(w)(s"(${a}, ${b})").mkString(" | ")
    val line = Array.fill(data.length)("=")

    for (i <- 0 until h){
        println(data)
        if (i < h-1){
            println(line.mkString(""))
        }
    }
}