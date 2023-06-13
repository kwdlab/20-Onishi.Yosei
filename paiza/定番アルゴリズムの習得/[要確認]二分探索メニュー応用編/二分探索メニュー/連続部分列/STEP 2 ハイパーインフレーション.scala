import scala.io.StdIn._
import scala.math.BigInt

object Main extends App {

    val line = readLine().trim().split(" ")
    val n = line(0).toInt
    val k = BigInt(line(1))
    val a = Array.ofDim[BigInt](n)
    val b = Array.ofDim[BigInt](n)
    val c = Array.ofDim[BigInt](n)
    val d = Array.ofDim[BigInt](n)

    for (i <- 0 until n) {
        val Array(ai, bi, ci, di) = readLine().trim().split(" ").map(BigInt(_))
        a(i) = ai
        b(i) = bi
        c(i) = ci
        d(i) = di
    }

    var left = BigInt(0)
    var right = BigInt("1000001")

    while (right - left > 1) {
        val mid = (left + right) / 2
        var sum = BigInt(0)

        for (i <- 0 until n){
            sum = sum + Array(a(i)*mid + b(i), c(i)*mid + d(i)).min
        }

        if (sum <= k) {
            left = mid
        } else {
            right = mid
        }
    }
    println(left)
}
//解答例使用済み