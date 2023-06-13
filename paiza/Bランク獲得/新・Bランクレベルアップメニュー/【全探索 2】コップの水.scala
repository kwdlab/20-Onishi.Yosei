import scala.io.StdIn._

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val w = Array.fill(n)(readLine().trim().toInt)
    
    val comb: Array[Int] = (1 to n).foldLeft(Array.empty[Int]) { (array, i) =>
        val tmp = w.combinations(i)
        val sums = tmp.map(_.sum)
        array ++ sums
    }

    println(comb.filter(_ <= x).max)
}