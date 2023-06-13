import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val a = readLine.trim().split(" ").map(_.toInt)

    def mainFunction(sum: Int, ans: Int, l: Int, u: Int): Int = {
        if (m <= sum){
            mainFunction(sum-a(l), Array(ans, u-l+1).min, l+1, u)
        } else {
            if (u + 1 == n){
                return ans
            } else {
                mainFunction(sum+a(u+1), ans, l, u+1)
            }
        }
    }
    
    val answer = mainFunction(a(0), n+1, 0, 0)
    if (answer == n+1) {
        println(-1)
    } else {
        println(answer)
    }
}
//解答例使用済み