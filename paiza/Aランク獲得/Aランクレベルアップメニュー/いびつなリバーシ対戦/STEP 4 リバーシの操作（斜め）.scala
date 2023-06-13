import scala.io.StdIn._

object Main extends App {
    val Array(h, w, y, x) = readLine().trim().split(" ").map(_.toInt)
    val s = Array.fill(h)(readLine().trim().split(""))

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

    checkCross(y, x, s)
    s(y)(x) = "*"
    for (i <- s){
        println(i.mkString(""))
    }
}