import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val Acube = Array.ofDim[Int](N, N, N)
    var ans = 0 

    for (i <- 0 until N; j <- 0 until N){
        Acube(i)(j) = readLine().split(" ").map(_.toInt)
    }
    
    for (x <- 0 until N; i <- 0 until N){
        var rowSum = 0
        for (j <- 0 until N){
            rowSum = rowSum + Acube(x)(i)(j)
        }
        ans = Array(rowSum, ans).max
    }
    for (y <- 0 until N; i <- 0 until N){
        var rowSum = 0
        var colSum = 0
        for (j <- 0 until N){
            rowSum = rowSum + Acube(i)(y)(j)
            colSum = colSum + Acube(j)(y)(i)
        }
        ans = Array(rowSum, colSum, ans).max
    }
    for (z <- 0 until N; i <- 0 until N){
        var rowSum = 0
        var colSum = 0
        for (j <- 0 until N){
            rowSum = rowSum + Acube(i)(j)(z)
            colSum = colSum + Acube(j)(i)(z)
        }
        ans = Array(rowSum, colSum, ans).max
    }

    for (x <- 0 until N){
        var leftRightDown = 0
        var leftRightUp = 0
        for (i <- 0 until N){
            leftRightDown = leftRightDown + Acube(x)(i)(i)
            leftRightUp = leftRightUp + Acube(x)(N-1-i)(i)
        }
        ans = Array(leftRightDown, leftRightUp, ans).max
    }
    for (y <- 0 until N){
        var leftRightDown = 0
        var leftRightUp = 0
        for (i <- 0 until N){
            leftRightDown = leftRightDown + Acube(i)(y)(i)
            leftRightUp = leftRightUp + Acube(N-1-i)(y)(i)
        }
        ans = Array(leftRightDown, leftRightUp, ans).max
    }
    for (z <- 0 until N){
        var leftRightDown = 0
        var leftRightUp = 0
        for (i <- 0 until N){
            leftRightDown = leftRightDown + Acube(i)(i)(z)
            leftRightUp = leftRightUp + Acube(i)(N-1-i)(z)
        }
        ans = Array(leftRightDown, leftRightUp, ans).max
    }

    var l1 = 0
    var l2 = 0
    var l3 = 0
    var l4 = 0

    for (i <- 0 until N){
        l1 = l1 + Acube(i)(i)(i)
        l2 = l2 + Acube(i)(N-1-i)(N-1-i)
        l3 = l3 + Acube(i)(N-1-i)(i)
        l4 = l4 + Acube(i)(i)(N-1-i)
    }
    ans = Array(l1, l2, l3, l4, ans).max
    println(ans)  
}

//解答例使用済み
//意味は分からない