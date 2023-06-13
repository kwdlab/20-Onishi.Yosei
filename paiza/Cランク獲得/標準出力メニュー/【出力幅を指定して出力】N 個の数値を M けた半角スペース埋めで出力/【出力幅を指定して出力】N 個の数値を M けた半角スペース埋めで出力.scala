import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)

    for (i <- 0 until n){
        val a = readLine().trim().toInt
        println(String.format(s"%${m}s", a).replace(" ", " "))
    }
}