import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val sd: Map[Int, String] = (0 until n).foldLeft(Map.empty[Int, String]) { (map, _) =>
        val line = readLine.split(" ")
        map + (line(1).toInt -> line(0))
    }
    val key = sd.keys.toList
    for (i <- key.sorted){
        println(sd(i))
    }
}
