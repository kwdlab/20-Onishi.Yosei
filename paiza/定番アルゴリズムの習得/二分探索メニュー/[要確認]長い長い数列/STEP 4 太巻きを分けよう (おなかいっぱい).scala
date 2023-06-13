import scala.io.StdIn._

object Main extends App {

    val Array(l, n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = readLine().trim().split(" ").map(_.toInt)
    val A = Array(0) ++ tmp ++ Array(l)

    def binarySearch(left: Int, right: Int): Int = {
        if (right - left <= 1) {
            return right
        } else {
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

            if (incParts() > n) {
                binarySearch(mid, right)
            } else {
                binarySearch(left, mid)
            }
        }
    }

    val left = A.sliding(2).map(pair => pair(1) - pair(0)).max - 1
    val result = binarySearch(left, l)
    println(result)
}

//解答例使用済み

/*
import scala.io.StdIn._

object Main extends App {

    val Array(l, n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = readLine().trim().split(" ").map(_.toInt)
    val A = Array(0) ++ tmp ++ Array(l)

    def binarySearch(left: Int, right: Int): Int = {
        if (right - left <= 1) {
            return right
        } else {
            val mid = (left + right) / 2

            var last = 0
            var index = 0
            var parts = 0

            def test():Unit = {
                while (true){
                    while (index+1 < k+2 && A(index+1)-A(last) <= mid){
                        index += 1
                    }
                    parts += 1
                    if (index == k+1){
                        return
                    }
                    last = index
                }            
            }
            test()
               
            if (parts > n) {
                binarySearch(mid, right)
            } else {
                binarySearch(left, mid)
            }
        }
    }

    var left = 0
    for (i <- 1 until k+2){
        left = left.max(A(i) - A(i-1))
    }
    val result = binarySearch(left-1, l)
    println(result)
}
*/