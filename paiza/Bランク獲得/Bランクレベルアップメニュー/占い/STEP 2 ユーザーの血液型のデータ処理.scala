import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val tmp = Array.fill(n)(readLine().trim().split(" "))

    val name = tmp.map(_(0))
    val userMap: Map[String, String] = tmp.foldLeft(Map.empty[String, String]) { (map, i) =>
        map + (i(0) -> i(1))
    }
    for (i <- name){
        println(i + " " + userMap(i))
    }
}
