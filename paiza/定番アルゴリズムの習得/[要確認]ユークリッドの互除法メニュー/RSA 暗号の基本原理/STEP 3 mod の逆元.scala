import scala.io.StdIn._

object Main extends App {

    val Array(m, a) = readLine().split(" ").map(_.toLong)
    
    def extGCD(a: Long, b: Long): (Long, Long, Long) = {
        if (b != 0){
            var (c, y, x) = extGCD(b, a%b)
            y = y - (a/b) * x
            return (c, x, y)
        }
        return (a, 1, 0)
    }

    val (c, x, y) = extGCD(a, m)
    val ans = (x + m) % m
    println(ans)
}

//解答例使用済み