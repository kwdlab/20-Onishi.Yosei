import scala.io.StdIn._

object Main extends App {

    val line = readLine().split(" ")
    val numA = line(0).toInt
    val numB = line(1).toInt

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

    println(s"${halfF(numA, numB, "C")} ${halfF(numA, numB, "S")}")
}
