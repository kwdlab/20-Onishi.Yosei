object Main extends App {

    val line = Array(1, 10, 2, 9, 3, 8, 4, 7, 5, 6)

    for (i <- 0 until line.length){
        if (line(i) == 8){
            println(i+1)
        }
    }
}
