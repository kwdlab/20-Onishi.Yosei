object Main extends App {

    val row = 9
    val column = 9

    for (i <- 0 until row){
        val result = Array.ofDim[String](column)
        for (j <- 0 until column){
            result(j) = s"${(i+1)*(j+1)}"
        }
        println(result.mkString(" "))
    }
}