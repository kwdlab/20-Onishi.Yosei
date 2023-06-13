import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().split(" "))

    for (i <- 0 until n; j <- 0 until k){
        if (a(i)(j) == "1"){
            println(s"${i+1} ${j+1}")
        }
    }
}