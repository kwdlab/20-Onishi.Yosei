import scala.io.StdIn._

object Main extends App {

    val HWD = readLine().split(" ").map(_.toInt)
    val H = HWD(0)
    val W = HWD(1)
    val D = HWD(2)
    val ans = Array.ofDim[Int](H, W)
    var count = 1

    D match {
        case 1 => case1()
        def case1() = {
            ans(0)(0) = 1
            count += 1

            for (i <- 1 until H) {
                for (j <- 0 to Math.min(i, W - 1)) {
                    ans(i - j)(j) = count
                    count += 1
                }
            }

            for (i <- 1 until W) {
                for (j <- 0 until Math.min(H, W - i)) {
                    ans(H - 1 - j)(i + j) = count
                    count += 1
                }
            }
        }
        case 2 => case2()
        def case2() = {
            for (i <- 0 until H) {
                for (j <- 0 until W) {
                    ans(i)(j) = count
                    count += 1
                }
            }
        }
        case 3 => case3()
        def case3() = {
            for (i <- 0 until W) {
                for (j <- 0 until H) {
                    ans(j)(i) = count
                    count += 1
                }
            }
        }
        case 4 => case4()
        def case4() = {
            ans(0)(0) = 1
            count += 1

            for (i <- 1 until W) {
                for (j <- 0 to Math.min(i, H - 1)) {
                    ans(j)(i - j) = count
                    count += 1
                }
            }

            for (i <- 1 until H) {
                for (j <- 0 until Math.min(H - i, W)) {
                    ans(i + j)(W - 1 - j) = count
                    count += 1
                }
            }
        }
    }

    for (i <- 0 until H) {
        val sb = new StringBuilder()
        for (j <- 0 until W) {
            if (j != 0) {
                sb.append(" ")
            }
            sb.append(ans(i)(j))
        }
        println(sb)
    }
}

//解答例使用済み