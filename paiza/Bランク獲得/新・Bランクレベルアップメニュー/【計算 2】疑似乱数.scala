import scala.io.StdIn._
import math._

object Main extends App {

    val XMN = readLine().split(" ").map(_.toInt)
    val X = XMN(0)
    val M = XMN(1)
    val N = XMN(2)
    var pow = 1
    var seed = 0

    for (i <- 0 until N){
        pow = pow * X
        pow = pow % M
        seed = seed + pow
        seed = seed % M
        println(seed)
    }
}

/*
import scala.io.StdIn._
import math._

object Main extends App {

    val XMN = readLine().split(" ").map(_.toInt)
    val X = XMN(0)
    val M = XMN(1)
    val N = XMN(2)
    var Xline : Array[Int] = Array.empty

    for (i <- 1 to N){
        Xline = Xline ++ Array(pow(X, i).toInt)
        println(Xline.sum % M)
    }
}
*/