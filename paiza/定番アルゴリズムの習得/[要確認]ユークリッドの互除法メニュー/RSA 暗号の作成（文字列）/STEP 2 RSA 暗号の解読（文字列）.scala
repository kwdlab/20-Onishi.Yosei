import scala.io.StdIn._
import scala.math._

object Main extends App {

    def divisor(n: BigInt): (BigInt, BigInt) = {
        for (i <- 2 to sqrt(n.toDouble).toInt) {
            if (n % i == 0) {
                return (i, n / i)
            }
        }
        (BigInt(-1), BigInt(-1))
    }

    def extgcd(a: BigInt, b: BigInt): (BigInt, BigInt, BigInt) = {
        if (b != 0) {
            val (c, y, x) = extgcd(b, a % b)
            val newY = y - (a / b) * x
            (c, x, newY)
        } else {
            (a, 1, 0)
        }
    }

    def modpow(a: BigInt, b: BigInt, m: BigInt): BigInt = {
        var ans = BigInt(1)
        var base = a
        var exp = b

        while (exp > 0) {
            if (exp.testBit(0)) {
                ans = (ans * base) % m
            }
            base = (base * base) % m
            exp >>= 1
        }
        ans
    }

    val Array(n, e, m) = readLine().trim().split(" ").map(BigInt(_))
    val (p, q) = divisor(n)
    val n_prime = (p - 1) * (q - 1)

    val (c, x, y) = extgcd(e, n_prime)
    val d = (x + n_prime) % n_prime
    var after = modpow(m, d, n)

    val letter = Array.fill(4)('\u0000')
    for (i <- 0 until 4) {
        for (j <- 0 until 7) {
            if (after % 2 == 1) {
                letter(i) = (letter(i) | (1 << j)).toChar
            }
            after >>= 1
        }
    }

    var output = ""
    for (i <- 0 until 4) {
        output += letter(3 - i)
    }
    println(output.trim())
}

//解答例使用済み