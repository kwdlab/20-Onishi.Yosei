import scala.io.StdIn._

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    var data: Array[Int] = Array.empty

    for (_ <- 0 until n-1){
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        if (a==x){
            data = data ++ Array(b)
        }else if (b==x){
            data = data ++ Array(a)
        }
    }
    for (i <- data.sorted){
        println(i)
    }
}
