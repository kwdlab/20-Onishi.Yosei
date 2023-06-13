import scala.io.StdIn._

object Main extends App {

    val N = readLine().toLong
    val Mod = 1000003L

    def loopMain(n: Long, m: Long): Long = {
        var p = 2L
        var ans = 1L
        var nc = n
        while (0 < nc) {
            if ((nc & 1) == 1){
                ans = (ans * p % m).toLong
            }
            p = (p * p % m).toLong
            nc = nc >> 1
        }
        return ans
    }
    
    val ans = loopMain(N, Mod)
    println(ans)
}

//解答例使用済み