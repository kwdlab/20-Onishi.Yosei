import scala.io.StdIn._

object Main extends App {
     
    val Array(n, k, p) = readLine().split(" ").map(_.toInt)
    val line = Array(p) ++ Array.fill(n)(readLine().toInt)

    def loop(cnt: Int, line: Array[Int]): Unit = {
        if (cnt == k){
            return 
        }
        val data = readLine().split(" ")
        if (data(0) == "join"){
            val newArray = line :+ data(1).toInt
            loop(cnt+1, newArray)
        } else {
            val newArray = line.sorted
            println(newArray.indexOf(p)+1)
            loop(cnt+1, newArray)
        }
    }
    loop(0, line)
}