import scala.io.StdIn._

object Main extends App {
    val Array(h, w, y, x) = readLine().split(" ").map(_.toInt)
    val s = Array.fill(h)(readLine().trim().split(""))

    def checkRow(x: Int, y: Int, s: Array[Array[String]]): Unit = {
        for (lr <- List(-1, 1)) {
            innerFunc(0)
            def innerFunc(cnt: Int): Unit = {
                val i = cnt + 1
                if (x + i * lr < 0 || x + i * lr >= w) {
                    return
                }
                else if (s(y)(x + i * lr) == "*") {
                    for (j <- (Array(x + i * lr, x).min to Array(x + i * lr, x).max)) {
                        s(y)(j) = "*"
                    }
                    return
                } else {
                    innerFunc(cnt + 1)
                }
            }
        }
    }

    def checkColumn(x: Int, y: Int, s: Array[Array[String]]): Unit = {
        for (lr <- List(-1, 1)) {
            innerFunc(0)
            def innerFunc(cnt: Int): Unit = {
                val i = cnt + 1
                if (y + i * lr < 0 || y + i * lr >= h) {
                    return
                }
                else if (s(y + i * lr)(x) == "*") {
                    for (j <- (Array(y + i * lr, y).min to Array(y + i * lr, y).max)) {
                        s(j)(x) = "*"
                    }
                    return
                } else {
                    innerFunc(cnt + 1)
                }
            }
        }
    }

    s(y)(x) = "*"
    checkRow(x, y, s)
    checkColumn(x, y, s)

    for (i <- s) {
        println(i.mkString(""))
    }
}
//解答例使用済み