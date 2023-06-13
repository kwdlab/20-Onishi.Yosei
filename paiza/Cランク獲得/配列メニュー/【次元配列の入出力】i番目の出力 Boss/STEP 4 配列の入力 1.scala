object Main extends App {

    val line = "8 1 3 3 8 1 1 3 8 8".split(" ")

    for (i <- 0 until line.length.toInt){
        println(line(i))
    }
}
