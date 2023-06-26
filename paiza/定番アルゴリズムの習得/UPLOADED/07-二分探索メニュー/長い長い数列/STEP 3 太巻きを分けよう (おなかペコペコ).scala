import scala.io.StdIn._

object Main extends App {

    val Array(l, n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = readLine().trim().split(" ").map(_.toInt)
    val A = Array(0) ++ tmp ++ Array(l)

    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int = {
        if (right - left <= 1) left
        else {
            val mid = (left + right) / 2

            @scala.annotation.tailrec
            def incParts(i: Int, last: Int, p: Int):Int = {
                if (i >= k+2) p
                else {
                    if (A(i) - A(last) >= mid) incParts(i+1, i, p+1)
                    else incParts(i+1, last, p)
                }
            }

            if (incParts(0, 0, 0) < n) binarySearch(left, mid)
            else binarySearch(mid, right)
        }
    }

    println(binarySearch(0, l+1))
}
//解答例使用済み
