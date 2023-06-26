import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)
    val INF = 1000000000
    var count = 0

    def merge(A: Array[Int], left: Int, mid: Int, right: Int) = {
        val nl = mid - left
        val nr = right - mid
        val L = Array.ofDim[Int](nl+1)
        val R = Array.ofDim[Int](nr+1)

        for (i <- 0 until nl){
            L(i) = A(left+i)
        }
        for (i <- 0 until nr){
            R(i) = A(mid+i)
        }
        L(nl) = INF
        R(nr) = INF

        var lindex = 0
        var rindex = 0
        for (i <- left until right){
            if(L(lindex) < R(rindex)){
                A(i) = L(lindex)
                lindex = lindex + 1
            }
            else {
                A(i) = R(rindex)
                rindex = rindex + 1
                count = count + 1
            }
        }
    }
    
    def mergeSort(A: Array[Int], left: Int, right: Int): Array[Int] = {
        if (left+1 < right){
            val mid = (left + right) / 2
            mergeSort(A, left, mid)
            mergeSort(A, mid, right)
            merge(A, left, mid, right)
        }
        return A
    }

    val result = mergeSort(An, 0, n)
    println(result.mkString(" "))
    println(count)
}
