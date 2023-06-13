import scala.io.StdIn._

object Main extends App {

    val Array(n, len) = readLine().trim().split(" ").map(_.toInt)
    val a = Array.fill(len)(0)
    
    for (i <- 0 until n){
        a(i) = readLine().trim().toInt
    }

    a.foreach(println)
}