import scala.io.StdIn._

object Main extends App {

    val x = readLine().toInt
    val Array(f1, f2) = readLine().split(" ").map(_.toInt)
    val Array(l, n) = readLine().split(" ").map(_.toInt)
    val tmp = readLine().split(" ").map(_.toInt)
    val s = tmp :+ l

    def calculateCost(i: Int, now: Long, cost: Long): Long = {
        if (i > n) {
            return cost
        } else {
            val diff = s(i) - now
            val updatedCost = {
                if (x < diff) {
                    cost + f1 * x + f2 * (diff - x)
                } else {
                    cost + f1 * diff
                }
            }
            calculateCost(i + 1, s(i), updatedCost)
        }
    }

    val totalCost = calculateCost(0, 0L, 0L)
    println(totalCost)
}