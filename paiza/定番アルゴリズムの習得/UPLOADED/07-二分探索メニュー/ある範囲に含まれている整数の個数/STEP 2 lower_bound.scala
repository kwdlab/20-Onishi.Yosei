import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt).sorted
    val q = readLine().toInt

    for (i <- 0 until q){
        val target = readLine().toInt
        println(n - binarySearch((l: Int, r: Int) => l >= r)(an, 0, n, target))
    }

    @scala.annotation.tailrec
    def binarySearch(exit: (Int, Int) => Boolean)(an: Array[Int], left: Int, right: Int, target: Int): Int = {
        if (exit(left, right)) right
        else {
            val mid = (left + right) / 2
            if (an(mid) < target) binarySearch(exit)(an, mid + 1, right, target) 
            else binarySearch(exit)(an, left, mid, target)
        }
    }
}