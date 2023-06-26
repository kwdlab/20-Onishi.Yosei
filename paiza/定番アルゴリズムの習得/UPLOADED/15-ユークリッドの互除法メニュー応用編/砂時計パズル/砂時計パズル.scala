import scala.io.StdIn._

object Main extends App {

    val Array(a, b, t) = readLine().split(" ").map(_.toInt)

    def gcd(x: Int, y: Int): Int = {
        if (y == 0){ return x }
        else { return gcd(y, x%y) }
    }

    if (t % gcd(a, b) == 0){
        println("Yes")
    } else {
        println("No")
    }
}
//解答例使用済み