object Main extends App {

    val line1 = Array(1)
    val line2 = Array(2, 3)
    val line3 = Array(4, 5, 6)
    val Dline = Array(line1, line2, line3)

    for (i <- 0 until Dline.length){
        println(Dline(i).length)
    }
}
