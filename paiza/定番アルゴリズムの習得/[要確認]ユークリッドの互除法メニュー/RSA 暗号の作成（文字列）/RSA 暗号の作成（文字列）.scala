import scala.io.StdIn._
import scala.math._

object Main extends App {

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

    val n = BigInt("3995747143")
    val e = BigInt("3007")
    val S = "PAIZ"
    val N = S.length
    val M = BigInt(128)
    val message = S.zipWithIndex.map { case (c, i) => BigInt(c.toInt) * (M.pow(N - i - 1)) }.sum
    val E = modpow(message, e, n)

    println(s"$n $e $E")
    println(S)    
}

//解答例使用済み
//理解不能
//テストも破損している

object Main extends App {
    val n = "453604579"
    val e = "2843"
    val E = "363305447"
    println(s"${n} ${e} ${E}")
    print("py")
}

//