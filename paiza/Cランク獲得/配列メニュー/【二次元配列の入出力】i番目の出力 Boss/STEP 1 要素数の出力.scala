object Main extends App {

    val line1 = Array(1, 2, 3, 4, 5, 6)
    val line2 = Array(8, 1, 3, 3, 1, 8)
    val line = Array(line1, line2)

    println(line.flatten.length)
}
