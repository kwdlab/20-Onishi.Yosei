import scala.io.StdIn._

object Main extends App {

    val Array(h, w, y, x) = readLine().split(" ").map(_.toInt)

    def dfs(times: Int, y: Int, x: Int): Unit = {
        if (times == 3) {
            println(s"$y $x")
        } else {
            if (y - 1 >= 0) {
                dfs(times + 1, y - 1, x)
            }
            if (x + 1 < w) {
                dfs(times + 1, y, x + 1)
            }
            if (y + 1 < h) {
                dfs(times + 1, y + 1, x)
            }
            if (x - 1 >= 0) {
                dfs(times + 1, y, x - 1)
            }
        }
    }

    dfs(0, y, x)
}
//解答例使用済み