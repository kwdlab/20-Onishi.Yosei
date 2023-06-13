import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val tmp = Array.fill(n)(readLine().trim().split(" "))   
    val name = tmp.map(_(0))

    val bloodMap: Map[String, String] = tmp.foldLeft(Map.empty[String, String]) { (map, tmp1) =>
        map + (tmp1(0) -> tmp1(1))
    }

    val m = readLine().toInt
    val colorMap: Map[String, String] = (0 until m).foldLeft(Map.empty[String, String]) { (map, _) =>
        val tmp2 = readLine().trim().split(" ")
        map + (tmp2(0) -> tmp2(1))
    }
    
    for (i <- name){
        println(i + " " + colorMap(bloodMap(i)))
    }
}
