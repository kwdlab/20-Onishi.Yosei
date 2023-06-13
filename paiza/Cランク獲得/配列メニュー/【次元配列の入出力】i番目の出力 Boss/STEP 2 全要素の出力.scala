object Main extends App {

    val line = "5 1 3 4 5 12 6 8 1 3".split(" ")

    for (i <- 0 until line.length.toInt){
        println(line(i))
    }
}
