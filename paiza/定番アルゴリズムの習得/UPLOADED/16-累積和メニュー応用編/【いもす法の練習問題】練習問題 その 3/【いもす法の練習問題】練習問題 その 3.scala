import scala.io.StdIn._

object Main extends App {

    val q = readLine().toInt
    val l = Array.ofDim[Int](q)
    val r = Array.ofDim[Int](q)
    val p = Array.ofDim[Int](q)
    val a = Array.fill(1000)(0)

    for (i <- 0 until q){
        val Array(x, y, z) = readLine().split(" ").map(_.toInt)
        l(i) = x
        r(i) = y
        p(i) = z
    }

    def imos(a: Array[Int], l: Array[Int], r: Array[Int], p: Array[Int]): Array[Int] = {
        for ((i,k) <- l.zip(p)){
            a(i-1) = a(i-1) + k
        }
        for ((j,k) <- r.zip(p)){
            a(j) = a(j) - k
        }
        return a
    }

    def makeCumulativeSum(a: Array[Int], n: Int): Array[Int] = {
        val s = Array.ofDim[Int](n+1)
        for (i <- 0 until n+1){
            if (i == 0){
                s(i) = 0
            } else {
                s(i) = a(i-1) + s(i-1)
            }
        }
        return s
    }

    def useCumulativeSum(s: Array[Int], l: Int, r: Int): Int = {
        return (s(r+1)-s(l))
    }

    val board = imos(a, l, r, p)
    val s = makeCumulativeSum(board, board.length)
    for (i <- 0 until (s.length)){
        if (s(i) == s.max){
            println(i)
        }
    }
}
