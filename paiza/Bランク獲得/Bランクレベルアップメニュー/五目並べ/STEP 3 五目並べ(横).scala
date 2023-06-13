import scala.io.StdIn._

object Main extends App {

    val result = Array.ofDim[String](5)
    for (j <- 0 until 5){
        val i = readLine().split("")

        if (i(0) == i(1) && i(0) == i(2) && i(0) == i(3) && i(0) == i(4) && i(0) == "O"){
            result(j) = "O"

        } else if (i(0) == i(1) && i(0) == i(2) && i(0) == i(3) && i(0) == i(4) && i(0) == "X"){
            result(j) = "X"
        
        } else {
            result(j) = "D"
        }
    }

    if (result.contains("O")){
        println("O")
    } else if (result.contains("X")){
        println("X")
    } else {
        println("D")
    }
}
