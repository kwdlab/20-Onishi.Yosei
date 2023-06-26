import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.HashMap

object Main extends App {

    val n1 = readLine().toInt
    val g1 = Array.fill(n1)(ArrayBuffer.empty[Int])
    for (_ <- 1 until n1) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g1(a - 1).append(b - 1)
        g1(b - 1).append(a - 1)
    }

    val n2 = readLine().toInt
    val g2 = Array.fill(n2)(ArrayBuffer.empty[Int])
    for (_ <- 1 until n2) {
        val Array(a, b) = readLine().split(" ").map(_.toInt)
        g2(a - 1).append(b - 1)
        g2(b - 1).append(a - 1)
    }

    if (n1 != n2) {
        println("NO")
    } else {
        val d = HashMap.empty[Int, Int]
        val permutation = (0 until n1).toList.permutations
        var check = false

        while (permutation.hasNext && !check) {
            val p = permutation.next()
            d.clear()
            for (i <- 0 until n1) {
                d(p(i)) = i
            }
            check = true
            for (i <- 0 until n1) {
                if (g1(i).length != g2(d(i)).length) {
                    check = false
                }
            }
        }

        if (check) {
            println("YES")
        } else {
            println("NO")
        }
    }
}

//解答例使用済み