import scala.io.StdIn._

object Main extends App {

    val HWN = readLine().split(" ").map(_.toInt)
    val H = HWN(0)
    val W = HWN(1)
    val N = HWN(2)
    val An = Array.ofDim[Int](H, W)
    val Sum = Array.ofDim[Int](H, W)

    for(i <- 0 until H){
        An(i) = readLine().split(" ").map(_.toInt)
    }

    for (i <- 0 until H; j <- 0 until W){
        Sum(i)(j) = An(i)(j)
        if (0 < i) {
            Sum(i)(j) = Sum(i)(j) + Sum(i-1)(j)
        }
        if (0 < j) {
            Sum(i)(j) = Sum(i)(j) + Sum(i)(j-1)
        }
        if (0 < i && 0 < j) {
            Sum(i)(j) = Sum(i)(j) - Sum(i-1)(j-1)
        }
    }

    for(i <- 0 until N){
        val yx = readLine().split(" ").map(_.toInt)
        val y = yx(0)
        val x = yx(1)
        println(Sum(y-1)(x-1))
    }
}

//解答例使用済み


/*
import scala.io.StdIn._

object Main extends App {

    val HWN = readLine().split(" ").map(_.toInt)
    val H = HWN(0)
    val W = HWN(1)
    val N = HWN(2)
    val An = Array.ofDim[Int](H+1, W)

    for(i <- 1 to H){
        An(i) = Array(0) ++ readLine().split(" ").map(_.toInt)
    }

    for(i <- 0 until N){
        val yx = readLine().split(" ").map(_.toInt)
        val y = yx(0)
        val x = yx(1)
        var result = 0
        for (j <- 1 to y; k <- 1 to x){
            result = result + An(j)(k)
        }
        println(result)
    }
}
*/