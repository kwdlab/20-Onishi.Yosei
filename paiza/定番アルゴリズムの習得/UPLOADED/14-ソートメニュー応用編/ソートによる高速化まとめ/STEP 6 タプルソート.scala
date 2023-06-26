import scala.io.StdIn._

object Main extends App {

    val Array(n, m, k) = readLine().split(" ").map(_.toInt)
    val a = Array.fill(n)(readLine().split(" ").map(_.toInt))

    def withSort(): Array[Array[Int]] = {
        val m = a(0).length

        val sorted = a.sortWith { (row1, row2) =>
            if (row1(k - 1) != row2(k - 1)) {
                row1(k - 1) < row2(k - 1)
            } else {
                def findMismatchIndex(row1: Array[Int], row2: Array[Int], index: Int): Int = {
                    if (index >= row1.length || row1(index) != row2(index)) {
                        return index
                    } else {
                        findMismatchIndex(row1, row2, index + 1)
                    }
                }
                val i = findMismatchIndex(row1, row2, 0)
                if (i == m) {
                    false
                } else {
                    row1(i) < row2(i)
                }
            }
        }
        return sorted
    }

    val result = withSort()
    for (line <- result){
        println(line.mkString(" "))
    }
}
//解答例使用済み