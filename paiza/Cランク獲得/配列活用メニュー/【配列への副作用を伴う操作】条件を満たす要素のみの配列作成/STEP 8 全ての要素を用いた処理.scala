import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)

    for (i <- 1 until n; j <- 0 until n){
        if (i > j){
            println(a(i)*a(j))
        }
    }
}