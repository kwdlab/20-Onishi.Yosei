import scala.io.StdIn._

object Main extends App {

    val yxh = readLine().split(" ").map(_.toInt)
    val y = yxh(0)
    val x = yxh(1)
    val h = yxh(2)
    val L = readLine().split(" ").map(_.toInt)
    val M = readLine().split(" ").map(_.toInt)

    if (L(0) >= h){
        if (L(1) >= List(y, x).max){
            println(M(0))
        } else if (L(2) >= List(y, x).sum){
            println(M(1))
        } else {
            println(M(2))
        }  
    } else {
        if (L(3) >= yxh.max){
            println(M(3))
        } else if (L(4) >= yxh.sum){
            println(M(4))
        } else {
            println(M(5) * yxh.product)
        }
    }
}