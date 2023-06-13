import scala.io.StdIn._

object Main extends App {
    
    val Array(n, k, s) = readLine().trim().split(" ").map(_.toInt)
    val result = Array.ofDim[String](k+1)
    val arrMap: Map[Int, Array[String]] = (1 to n).foldLeft(Map.empty[Int, Array[String]]) { (map, i) =>
        map + (i -> readLine().split(" "))
    }

    def searchPath(cnt: Int, pos: Int): Unit = {
        if (cnt == k+1){
            return
        } else {
            val newPos = {
                if (cnt == 0){
                    s
                } else {
                    arrMap(pos)(readLine().trim().toInt).toInt
                }
            }
            result(cnt) = arrMap(newPos)(0)
            searchPath(cnt+1, newPos)
        }
    }
    searchPath(0, 0)
    println(result.mkString(""))
}