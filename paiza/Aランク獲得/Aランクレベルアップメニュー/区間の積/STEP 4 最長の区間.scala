import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val a = readLine.trim().split(" ").map(_.toInt)

    def mainFunction(sum: Int, ans: Int, l: Int, u: Int): Int = {
        if (m < sum){
            mainFunction(sum-a(l), ans, l+1, u)
        } else {
            if (u + 1 == n){
                return Array(ans, u-l+1).max
            } else {
                mainFunction(sum+a(u+1), Array(ans, u-l+1).max, l, u+1)
            }
        }
    }
    
    val answer = mainFunction(a(0), 0, 0, 0)
    println(answer)
}
//解答例使用済み