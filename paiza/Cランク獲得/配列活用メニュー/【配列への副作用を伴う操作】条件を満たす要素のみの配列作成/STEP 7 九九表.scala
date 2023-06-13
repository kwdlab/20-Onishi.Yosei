object Main extends App {

    val n = 9
    val table = Array.ofDim[Int](n, n)
    for (i <- 1 to n; j <- 1 to n) {
        table(i-1)(j-1) = i * j
    }

    for (i <- table){
        println(i.mkString(" "))
    }
}
