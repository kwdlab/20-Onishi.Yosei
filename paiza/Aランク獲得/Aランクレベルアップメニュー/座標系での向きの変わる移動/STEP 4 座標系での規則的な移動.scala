import scala.io.StdIn._

object Main extends App {
    
    val YXN = readLine().split(" ")
    var X = YXN(0).toInt
    var Y = YXN(1).toInt
    val N = YXN(2).toInt
    val direct = Array("N", "E", "S", "W")

    def move(Dir: String): Unit = {
        Dir match {
            case "N" => Y = Y-1
            case "S" => Y = Y+1
            case "E" => X = X+1
            case "W" => X = X-1
        }
    }
    var length = 1
    var d = 1
    var now = 1
    var first = true

    for (i <- 0 until N) {
        move(direct(d % 4))
        length = length-1

        if (!first && length == 0) {
            first = true
            now = now+1
            length = now
            d = d+1
        } else if (length == 0) {
            length = now
            first = false
            d = d+1
        }
    }

    println(s"${X} ${Y}")
}