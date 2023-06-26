import scala.io.StdIn.readLine
import scala.math.BigInt

object Main extends App {

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

    val Array(p, q, e, m) = readLine().trim().split(" ").map(BigInt(_))
    val n = p * q
    val n_prime = (p - 1) * (q - 1)

    val (c, x, y) = extgcd(e, n_prime)
    val d = (x + n_prime) % n_prime
    val afterM = modpow(m, d, n)

    println(afterM.toChar)
}

//解答例使用済み