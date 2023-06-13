import scala.io.StdIn._

object Main extends App {
    val n = readLine().trim.toLong
    val Array(a, cal, b) = readLine().split(" ")
    
    val result = cal match {
        case "+" => ((a.toLong % n) + (b.toLong % n)) % n
        case "-" => ((a.toLong % n) - (b.toLong % n) + n) % n
        case "*" => (a.toLong % n) * (b.toLong % n) % n
        case _   => powerMod(a.toLong % n, b.toInt, n)
    }

    def powerMod(base: Long, exponent: Int, modulus: Long): Long = {
        var result = 1L
        var b = base
        var e = exponent
        while (e > 0) {
        if (e % 2 == 1) {
            result = (result * b) % modulus
        }
        b = (b * b) % modulus
        e = e / 2
        }
        return result
    }

    println(result)
}
//解答例使用済み