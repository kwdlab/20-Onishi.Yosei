import scala.io.StdIn._

object Main extends App {

    val S = readLine().split("").map(_.toInt).reverse
    val T = readLine().split("").map(_.toInt).reverse
    var c = Array.fill(S.length+1)(0).map(_.toInt).reverse
    var STsum : Array[Int] = Array.empty

    for (i <-0 until S.length){
        var tSum = S(i) + T(i) + c(i)
        if (tSum > 9){
            tSum = tSum - 10
            c(i+1) = 1
        }
        STsum = STsum ++ Array(tSum)
    }
    if (c(S.length) == 1){
        STsum = STsum ++ Array(1)
    }

    println(STsum.reverse.mkString(""))
}