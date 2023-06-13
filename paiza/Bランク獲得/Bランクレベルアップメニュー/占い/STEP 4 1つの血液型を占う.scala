import scala.io.StdIn._

object Main extends App {

    val T = readLine()
    val m = readLine().toInt
    val tmp = Array.fill(m)(readLine().trim().split(" "))

    val name = tmp.map(_(0))
    val userMap: Map[String, String] = tmp.foldLeft(Map.empty[String, String]) { (map, i) =>
        map + (i(0) -> i(1))
    }
    
    println(userMap(T))
}
