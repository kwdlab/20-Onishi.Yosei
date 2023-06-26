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

    val input = readLine().trim().split(" ").map(BigInt(_))
    val p = input(0)
    val q = input(1)
    val e = input(2)
    val M = input(3)
    val n = p * q
    val n_prime = (p - 1) * (q - 1)

    val (c, x, y) = extgcd(e, n_prime)
    val d = (x + n_prime) % n_prime
    val E = modpow(M, e, n)
    val afterM = modpow(E, d, n)

    println(d)
    println(E)
    println(afterM)
}

//解答例使用済み
//Longでも精度が足りないらしい?