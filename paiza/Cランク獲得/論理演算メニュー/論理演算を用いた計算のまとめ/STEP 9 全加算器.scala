import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt
    val numC1 = line(2).toInt

    def halfF(x: Int, y: Int, z: String): Int = {
        if (z == "C"){
            andF(x, y)
        } else {
            xorF(x, y)
        }
    }

    def andF(x: Int, y: Int): Int = {
        if (x == 1 && y == 1){ // AND C
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

    val Cx = halfF(numA, numB, "C")
    val Sy = halfF(numA, numB, "S")
    val Cy = halfF(Sy, numC1, "C")
    val S = halfF(Sy, numC1, "S")
    println(s"${xorF(Cx, Cy)} ${S}")
}
