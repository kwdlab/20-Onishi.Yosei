import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)
    val q = readLine().toInt

    for (i <- 0 until q){
        val target = readLine().toInt
        if (binarySearch((l: Int, r: Int) => l > r)(an, 0, n-1, target)) println("Yes")
        else println("No")
    }

    @scala.annotation.tailrec
    def binarySearch(exit: (Int, Int) => Boolean)(an: Array[Int], left: Int, right: Int, target: Int): Boolean = {
        if (exit(left, right)) false
        else {
            val mid = (left + right) / 2
            if (an(mid) < target) binarySearch(exit)(an, mid + 1, right, target) 
            else if (an(mid) > target) binarySearch(exit)(an, left, mid - 1, target)
            else true
        }
    }
}