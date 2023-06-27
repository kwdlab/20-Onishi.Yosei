import scala.io.StdIn._

object Main extends App {

    val Array(h, w) = readLine().split(" ").map(_.toInt)
    val s = Array.fill(h)(readLine().split(""))

    def dfs(y: Int, x: Int): Unit = {
        s(y)(x) = "#"
        val dx = Array(-1, 1, 0, 0)
        val dy = Array(0, 0, -1, 1)

        for (i <- 0 until 4) {
            val nx = x + dx(i)
            val ny = y + dy(i)
            if (0 <= ny && ny < h && 0 <= nx && nx < w && s(ny)(nx) == ".") {
                dfs(ny, nx)
            }
        }
    }

    val ans = (for {
        i <- 0 until h
        j <- 0 until w
        if s(i)(j) == "."
    } yield {
        dfs(i, j)
        1
    }).sum

    println(ans)
}
//解答例使用済み