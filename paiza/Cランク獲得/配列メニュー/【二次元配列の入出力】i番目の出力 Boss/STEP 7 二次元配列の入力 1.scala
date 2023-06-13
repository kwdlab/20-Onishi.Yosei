object Main extends App {

    val line1 = Array(1, 3, 5, 7)
    val line2 = Array(8, 1, 3, 8)
    val Dline = Array(line1, line2)

    for (i <- 0 until Dline.length){
        println(Dline(i).mkString(" "))
    }
}
