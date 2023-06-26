import scala.io.StdIn._

object Main extends App {

    val Array(n, a, c) = readLine().split(" ").map(_.toInt)

    def gcd(x: Int, y: Int): Int = {
        if (y == 0){ return x }
        else { return gcd(y, x%y) }
    }
    def roopGCD(cnt: Int, min: Int, flag: Boolean): Boolean = {
        if (cnt < 1001){
            val test = {
                if (n % gcd(min, cnt) != 0){
                    println(cnt)
                    false
                } else {
                    flag
                }
            }
            roopGCD(cnt+1, min, test)
        } else {
            return flag
        }
    }

    val minM = gcd(a, c)
    val none = roopGCD(1, minM, true)
    if (none){
        println(-1)
    }
}
//解答例使用済み