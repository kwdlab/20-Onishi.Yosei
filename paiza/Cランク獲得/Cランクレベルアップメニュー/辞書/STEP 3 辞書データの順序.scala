import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val s = Array.fill(n)(readLine())
    
    val m = readLine().toInt
    val p = Array.fill(m)(readLine().split(" "))

    for (name <- s.sorted){
        println(p.filter(_(0) == name).map(_(1)).map(_.toInt).sum)
    }
}