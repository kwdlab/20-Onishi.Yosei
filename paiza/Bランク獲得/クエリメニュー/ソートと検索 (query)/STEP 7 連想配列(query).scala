import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k) = readLine().split(" ").map(_.toInt)

    val numID: Map[Int, String] = (0 until n).foldLeft(Map.empty[Int, String]) { (map, _) =>
        val data = readLine().split(" ")
        map + (data(0).toInt -> data(1)) 
    }

    def loop(cnt: Int, numID: Map[Int, String]): Unit = {
        if (cnt == k){
            return 
        }
        val op = readLine().split(" ")

        if (op(0) == "join"){
            val newMap = numID + (op(1).toInt -> op(2))
            loop(cnt+1, newMap)
        } else if (op(0) == "leave"){
            val newMap = numID - op(1).toInt
            loop(cnt+1, newMap)
        } else if (op(0) == "call"){
            println(numID(op(1).toInt))
            loop(cnt+1, numID)
        }
    }
    loop(0, numID)
}