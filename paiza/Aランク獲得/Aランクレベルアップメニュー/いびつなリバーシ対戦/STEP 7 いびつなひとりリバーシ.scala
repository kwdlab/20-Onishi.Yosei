import scala.io.StdIn._

object Main extends App {
    val Array(h, w, n) = readLine().split(" ").map(_.toInt)
    val s = Array.fill(h)(readLine().trim().split(""))

    def checkRow(x: Int, y: Int, s: Array[Array[String]]): Unit = {
        for (lr <- List(-1, 1)) {
            innerFunc(0)
            def innerFunc(cnt: Int): Unit = {
                val i = cnt + 1
                if (x + i * lr < 0 || x + i * lr >= w) {
                    return
                }
                else if (s(y)(x + i * lr) == "#"){
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
                } else if (s(y + i * lr)(x) == "#") {
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
    def checkCross(x: Int, y: Int, s: Array[Array[String]]): Unit = {
        for (lr <- List(List(-1, -1), List(1, -1), List(-1, 1), List(1, 1))) {
            innerFunc(0)
            def innerFunc(cnt: Int): Unit = {
                val i = cnt + 1
                if (y + i * lr(0) < 0 || y + i * lr(0) >= h) {
                    return
                }
                else if (x + i * lr(1) < 0 || x + i * lr(1) >= w) {
                    return
                } 
                else if (s(y + i * lr(0))(x + i * lr(1)) == "#") {
                    return
                }
                else if (s(y + i * lr(0))(x + i * lr(1)) == "*") {
                    for (j <- 0 until i) {
                        s(y+lr(0)*j)(x+lr(1)*j) = "*"
                    }
                    return 
                } else {
                    innerFunc(cnt + 1)
                }
            }
        }
    }
    for (i <- 0 until n){
        val Array(y, x) = readLine().split(" ").map(_.toInt)
        checkRow(x, y, s)
        checkColumn(x, y, s)
        checkCross(x, y, s)
        s(y)(x) = "*"
    }

    for (i <- s){
        println(i.mkString(""))
    }
}