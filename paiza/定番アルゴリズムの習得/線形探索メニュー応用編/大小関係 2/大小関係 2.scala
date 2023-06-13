import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ").map(_.toInt)

    def mainLoop(n: Int, a: Array[Int]): Int = {
        var ans = 0
        var middle = 1
        while (middle < n - 1) {
            var left = middle - 1
            var right = middle + 1
            var middleNum = 0
            var flag = (right < n)

            while (flag && (((a(left) < a(middle)) && (a(middle) > a(right))) || ((a(left) > a(middle)) && (a(middle) < a(right))))) {
                left = middle
                middle = right
                right = right + 1
                middleNum = middleNum + 1

                if (right >= n){
                    flag = false
                }
            }
            ans = ans + middleNum * (middleNum - 1) / 2 + middleNum
            if (middleNum == 0) {
                middle = middle + 1
            }
        }
        return ans
    }
    println(mainLoop(n, an))
}

//解答例使用済み