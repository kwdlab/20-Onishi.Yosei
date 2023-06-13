import scala.io.StdIn._

object Main extends App {

    val Array(h, w, n) = readLine().split(" ").map(_.toInt)
    val an = Array.fill(h)(readLine().split(" ").map(_.toInt))
    val sum = Array.ofDim[Int](h,w)

    for (i <- 0 until h; j <- 0 until w){
        sum(i)(j) = an(i)(j)
        if (0 < i) {
            sum(i)(j) = sum(i)(j) + sum(i-1)(j)
        }
        if (0 < j) {
            sum(i)(j) = sum(i)(j) + sum(i)(j-1)
        }
        if (0 < i && 0 < j) {
            sum(i)(j) = sum(i)(j) - sum(i-1)(j-1)
        }
    }

    for(i <- 0 until n){
        val Array(a, b, c, d) = readLine().split(" ").map(_.toInt - 1)
        val tmp = sum(c)(d)

        val tmp1 = if (0 < a && 0 < b) {
            tmp + sum(a-1)(b-1)
        } else {
            tmp
        }
        val tmp2 = if (0 < a) {
            tmp1 - sum(a-1)(d)
        } else {
            tmp1
        }
        val tmp3 = if (0 < b) {
            tmp2 - sum(c)(b-1)
        } else {
            tmp2
        }
        println(tmp3)
    }
}