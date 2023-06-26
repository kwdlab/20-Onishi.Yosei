import scala.io.StdIn._

object Main extends App {

    val Array(l, n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = readLine().trim().split(" ").map(_.toInt)
    val A = Array(0) ++ tmp ++ Array(l)

    @scala.annotation.tailrec
    def binarySearch(left: Int, right: Int): Int = {
        if (right - left <= 1) right
        else {
            val mid = (left + right) / 2
            
            def incParts():Int = {
                var last = 0
                var index = 0
                var parts = 0
                while (true){
                    while (index+1 < k+2 && A(index+1)-A(last) <= mid){
                        index += 1
                    }
                    parts += 1
                    if (index == k+1){
                        return parts
                    }
                    last = index
                }
                return -1
            }

            if (incParts() > n) binarySearch(mid, right)
            else binarySearch(left, mid)
        }
    }

    val left = A.sliding(2).map(pair => pair(1) - pair(0)).max - 1
    println(binarySearch(left, l))
}
//解答例使用済み
