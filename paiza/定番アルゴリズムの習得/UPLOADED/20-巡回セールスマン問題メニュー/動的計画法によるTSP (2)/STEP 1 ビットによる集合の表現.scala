import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    if (k != 0){
        val s = readLine().trim().split(" ").map(_.toInt)
        val city = Array.fill[Int](n)(0)

        for (i <- s){
            city(i) = 1
        }
        
        val result = Integer.parseInt(city.mkString("").reverse, 2)
        println(result)        
    } else {
        println(0)
    }
}