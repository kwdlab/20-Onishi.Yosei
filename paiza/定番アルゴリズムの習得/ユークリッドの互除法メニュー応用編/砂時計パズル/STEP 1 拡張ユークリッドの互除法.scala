import scala.io.StdIn._

object Main extends App {

    val Array(a, b) = readLine().split(" ").map(_.toLong)
    
    def extGCD(a: Long, b: Long): (Long, Long, Long) = {
        if (b != 0){
            val (c, tmp, x) = extGCD(b, a%b)
            val y = tmp - (a/b) * x
            return (c, x, y)
        }
        return (a, 1, 0)
    }

    val (c, x, y) = extGCD(a, b)
    println(s"${x} ${y}")
}