import scala.io.StdIn._

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.fill(n)(readLine().trim().toInt)
    val k = readLine().trim().toInt
    
    println(a.indexOf(k) + 1)
}
