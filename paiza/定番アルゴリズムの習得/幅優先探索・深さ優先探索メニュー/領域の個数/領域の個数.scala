import scala.io.StdIn._

object Main extends App {

    def dfs(y: Int, x: Int): Unit = {
        S(y)(x) = "#"
        val dx = Array(-1, 1, 0, 0)
        val dy = Array(0, 0, -1, 1)

        for (i <- 0 until 4) {
            val nx = x + dx(i)
            val ny = y + dy(i)
            if (0 <= ny && ny < h && 0 <= nx && nx < w && S(ny)(nx) == ".") {
                dfs(ny, nx)
            }
        }
    }

    val Array(h, w) = readLine().split(" ").map(_.toInt)
    val S = Array.ofDim[String](h, w)
    for (i <- 0 until h) {
        S(i) = readLine().split("")
    }

    var ans = 0
    for (i <- 0 until h) {
        for (j <- 0 until w) {
            if (S(i)(j) == ".") {
                dfs(i, j)
                ans += 1
            }
        }
    }
    println(ans)
}
//解答例使用済み