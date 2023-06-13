import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = Array.fill(n)(readLine())
    
    val m = readLine().toInt
    val p = Array.fill(m)(readLine().split(" "))

    val name = readLine()

    println(p.filter(_(0) == name).map(_(1)).map(_.toInt).sum)
}
