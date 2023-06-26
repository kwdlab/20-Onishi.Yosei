import scala.io.StdIn._
import scala.math.BigInt

object Main extends App {

    val n = readLine().trim().toInt
    val a = Array.ofDim[BigInt](n)
    val b = Array.ofDim[BigInt](n)
    val tmpc = Array.ofDim[BigInt](n)

    for (i <- 0 until n) {
        val Array(ai, bi, ci) = readLine().trim().split(" ").map(BigInt(_))
        a(i) = ai
        b(i) = bi
        tmpc(i) = ci
    }
    val c = tmpc.sorted
    
    var left = BigInt("-1000000000")
    var right = BigInt("1000000000")

    while (right - left > 1) {
        val mid = (left + right) / 2

        val tmpd = Array.ofDim[BigInt](n)
        for (i <- 0 until n) {
            tmpd(i) = a(i) * mid + b(i)
        }
        val d = tmpd.sorted

        var pos = 0
        for (i <- 0 until n){
            if (d(i) > c(pos)){
                pos += 1
            }
        }

        if (pos > n/2) {
            right = mid
        } else {
            left = mid
        }
    }
    println(right)
}
//解答例使用済み