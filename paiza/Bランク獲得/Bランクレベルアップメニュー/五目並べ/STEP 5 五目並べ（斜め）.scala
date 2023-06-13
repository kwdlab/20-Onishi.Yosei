import scala.io.StdIn._

object Main extends App {

    val main = Array.ofDim[String](5, 5)
    val trans = Array.ofDim[String](5, 5)
    val cross = Array.ofDim[String](2, 5)
    val result = Array.ofDim[String](5)

    for (i <- 0 until 5){
        main(i) = readLine().split("")
    }
    for (i <- 0 until 5){
        for (j <- 0 until 5){
            trans(i)(j) = main(j)(i)
        }
    }
    cross(0) = Array(main(0)(0), main(1)(1), main(2)(2), main(3)(3), main(4)(4))
    cross(1) = Array(main(0)(4), main(1)(3), main(2)(2), main(3)(1), main(4)(0))

    for (j <- 0 until 2){
        val i = cross(j)
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
