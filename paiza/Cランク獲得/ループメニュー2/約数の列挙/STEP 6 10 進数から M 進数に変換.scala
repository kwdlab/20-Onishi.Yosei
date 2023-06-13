import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)

    def convert10to2(n: Int, result: String): String = {
        if (n < m){
            return result + s"${n}"
        } else {
            convert10to2(n / m, result + s"${n % m}")
        }
    }
    
    println(convert10to2(n, "").reverse)
}
