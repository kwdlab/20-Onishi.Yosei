import scala.io.StdIn._

object Main extends App {

    val k = readLine().toInt
    val a = Array.ofDim[Int](100, 100)
    val b = Array.ofDim[Int](10000)
    val rangeMax = Array.ofDim[Int](100)

    for (i <- 0 until 100; j <- 0 until 100){
        a(i)(j) = readLine().toInt
        b(i*100+j) = a(i)(j)
    }
    for (i <- 0 until 100){
        rangeMax(i) = a(i).max
    }

    for (i <- 0 until k){
        val Array(l, r) = readLine().split(" ").map(_.toInt - 1)

        def innerLoop(now: Int, ans: Int): Int = {
            if (now > r){
                return ans
            } else if (now % 100 == 0 && now + 99 <= r) {
                val newAns = List(ans, rangeMax(now / 100)).max
                val newNow = now + 100
                innerLoop(newNow, newAns)
            } else {
                val newAns = List(ans, b(now)).max
                val newNow = now + 1
                innerLoop(newNow, newAns)
            }
        }
        println(innerLoop(l, b(l)))
    }
}
//解答例使用済み

        while (now <= r) {
            if (now % 100 == 0 && now + 99 <= r) {
                ans = List(ans, rangeMax(now / 100)).max
                now = now + 100
            } else {
                ans = List(ans, b(now)).max
                now = now + 1
            }
        }