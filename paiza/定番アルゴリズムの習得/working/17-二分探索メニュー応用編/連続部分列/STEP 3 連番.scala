import scala.io.StdIn._
import scala.math.BigInt

object Main extends App {

    val line = readLine().trim().split(" ")
    val n = line(0).toInt
    val k = BigInt(line(1))
    val a = readLine().trim().split(" ").map(BigInt(_))

    var left = BigInt(1)
    var right = BigInt(n+0)

    while (right - left > 1) {
        val mid = (left + right) / 2
        var sum = BigInt(0)
        var count = BigInt(0)

        for (i <- 0 until n){
            count += 1
            if (count >= mid){
                sum += 1
                count = 0
            }
            if (i != n-1 && a(i)+1 != a(i+1)){
                count = 0
            }
        }

        if (sum >= k) {
            left = mid
        } else {
            right = mid
        }
    }
    println(left)
}
//解答例使用済み