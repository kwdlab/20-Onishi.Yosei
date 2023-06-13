import scala.io.StdIn._
import scala.math.BigInt

object Main extends App {

    val line = readLine().split(" ")
    val n = line(0).toInt
    val k = line(1).toLong
    val tmpa = readLine().split(" ").map(_.toInt)
    val a = tmpa ++ Array(0)

    var left = 0
    var right = 1000000000

    while (right - left > 1) {
        val mid = (left + right) / 2

        var sum = BigInt(n.toLong) * (n.toLong + 1) / 2
        var cnt = 0

        for (i <- 0 to n) {
            if (a(i) > mid) {
                cnt += 1
            } else {
                sum -= BigInt(cnt.toLong) * (cnt.toLong + 1) / 2
                cnt = 0
            }
        }

        if (sum < k) {
            left = mid
        } else {
            right = mid
        }
    }

    println(right)
}

//解答例使用済み