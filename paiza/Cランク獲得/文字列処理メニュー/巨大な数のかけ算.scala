import scala.io.StdIn._

object Main extends App {

    val S = readLine().split("").map(_.toInt).reverse
    val T = readLine().toInt
    var c = Array.fill(S.length+1)(0).map(_.toInt).reverse
    var STX : Array[Int] = Array.empty

    for (i <-0 until S.length){
        var tX = S(i) * T + c(i)
        var count = 0
        while (tX > 9){
            tX = tX - 10
            count = count + 1
        }
        c(i+1) = count
        STX = STX ++ Array(tX)
    }
    if (c(S.length) != 0){
        STX = STX ++ Array(c(S.length))
    }
    
    if (T != 0){
        println(STX.reverse.mkString(""))
    } else {
        println(0)
    }
}