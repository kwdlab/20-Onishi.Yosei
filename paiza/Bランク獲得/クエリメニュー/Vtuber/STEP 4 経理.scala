import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    val keyList = Array.fill(n)(readLine().trim())

    val keyData: Map[String, String] = (0 until k).foldLeft(Map.empty[String, String]) { (map, _) =>
        val Array(a, p, m) = readLine().split(" ")
        val PM = p + "/" + m
        if (map.contains(a)) {
            map.updated(a, map(a) + " " + PM)
        } else {
            map + (a -> PM)
        }
    }

    for (i <- keyList) {
        println(i)
        if (keyData.contains(i)) {
            for (j <- keyData(i).split(" ")) {
                println(j.split("/").mkString(" "))
            }       
        }
        println("-----")   
    }
}