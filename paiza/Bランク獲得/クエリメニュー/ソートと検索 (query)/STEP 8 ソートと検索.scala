import scala.io.StdIn._

object Main extends App {
     
    val Array(n, x, p) = readLine().split(" ").map(_.toInt)
    val line = Array.fill(n)(readLine().toInt)

    val result = Array(p) ++ line ++ Array(x) 
    println(result.sorted.indexOf(p)+1)
}
