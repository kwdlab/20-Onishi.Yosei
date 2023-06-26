import scala.io.StdIn._

object Main extends App {
    def modPow(a: Long, b: Long, m: Long): Long = {
        var ans = 1L
        var A = a
        var B = b
        while (B > 0) {
            if ((B & 1) == 1) {
                ans = (ans * A) % m
            }
            A = (A * A) % m
            B >>= 1
        }
        return ans
    }

    val Array(a, b, m) = readLine().split(" ").map(_.toLong)
    val result = modPow(a, b, m)
    println(result)
}
//解答例使用済み