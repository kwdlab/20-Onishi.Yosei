import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k, x) = readLine().split(" ").map(_.toInt)
    
    for (i <- 0 until n){
        val s = readLine().split(",").map(_.toInt)
        if (s(k-1) >= x){
            println(s.mkString(","))
        }
    }
}
