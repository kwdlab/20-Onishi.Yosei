import scala.io.StdIn._

object Main extends App {

    val i = readLine().split("")

    if (i(0) == i(1) && i(0) == i(2) && i(0) == i(3) && i(0) == i(4) && i(0) == "O"){
        println("O")

    } else if (i(0) == i(1) && i(0) == i(2) && i(0) == i(3) && i(0) == i(4) && i(0) == "X"){
        println("X")
    
    } else {
        println("D")
    }


}
