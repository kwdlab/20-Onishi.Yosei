import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k) = readLine().split(" ").map(_.toInt)

    val numID: Map[Int, String] = (0 until n).foldLeft(Map.empty[Int, String]) { (map, _) =>
        val data = readLine().split(" ")
        map + (data(0).toInt -> data(1)) 
    }

    for (i <- 0 until k){
        println(numID(readLine().toInt))
    }
}
