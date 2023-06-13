import scala.io.StdIn._

object Main extends App {

    val U = readLine()

    val n = readLine().toInt
    val bloodMap: Map[String, String] = (0 until n).foldLeft(Map.empty[String, String]) { (map, _) =>
        val tmp1 = readLine().trim().split(" ")
        map + (tmp1(0) -> tmp1(1))
    }

    val m = readLine().toInt
    val colorMap: Map[String, String] = (0 until m).foldLeft(Map.empty[String, String]) { (map, _) =>
        val tmp2 = readLine().trim().split(" ")
        map + (tmp2(0) -> tmp2(1))
    }
    println(colorMap(bloodMap(U)))
}
