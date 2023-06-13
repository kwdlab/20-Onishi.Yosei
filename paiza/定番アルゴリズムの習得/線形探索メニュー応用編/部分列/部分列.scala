import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val an = readLine().split(" ").map(_.toInt)
    val bm = readLine().split(" ").map(_.toInt)

    def checkOut(): Boolean = {
        var i = 0
        var j = 0
        while (i < n && j < m) {
            if (an(i) == bm(j)) {
                j = j + 1
            }
            i = i + 1
        }
        return (j == m)
    }

    if (checkOut()){
        println("Yes")
    } else {
        println("No")
    }
}
//解答例使用済み