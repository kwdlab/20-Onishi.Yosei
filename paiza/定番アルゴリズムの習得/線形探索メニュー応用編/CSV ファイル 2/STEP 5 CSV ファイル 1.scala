import scala.io.StdIn._

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    
    for (i <- 0 until n){
        val s = readLine().split(",").map(_.toInt)
        if (s(1) >= x){
            println(s.mkString(","))
        }
    }
}
