import scala.io.StdIn._
import scala.math.BigInt

object Main extends App {

    val line = readLine().trim().split(" ")
    val n = line(0).toInt
    val k = BigInt(line(1))
    val a = Array.ofDim[BigInt](n)
    val b = Array.ofDim[BigInt](n)

    for (i <- 0 until n) {
        val Array(ai, bi) = readLine().trim().split(" ").map(BigInt(_))
        a(i) = ai
        b(i) = bi
    }

    var left = BigInt(0)
    var right = BigInt("1000000000000000001")

    while (right - left > 1) {
        val mid = (left + right) / 2
        var sum = BigInt(0)

        for (i <- 0 until n){
            sum += (b(i) + mid + a(i) - 1) / a(i)
        }

        if (sum <= k) left = mid
        else right = mid
    }
    println(left)
}
//解答例使用済み