import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt
    val numC = line(2).toInt
    val numD = line(3).toInt

    def andF(x: Int, y: Int): Int = {
        if (x == 1 && y == 1){ // AND C
            1
        } else {
            0
        }
    }
    def orF(x: Int, y: Int): Int = {
        if (x == 1 || y == 1){
            1
        } else {
            0
        }  
    }
    def xorF(x: Int, y: Int): Int = {
        if (!(x == y)){ // XOR S
            1
        } else {
            0
        }
    }
    def notF(x: Int): Int = {
        if (x == 1){
            0
        } else {
            1
        }  
    }

    println(xorF(notF(orF(andF(notF(numA),notF(numB)),notF(numC))),numD))
}
