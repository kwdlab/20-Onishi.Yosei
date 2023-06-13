object Main extends App {

    val n = 9
    val table = Array.ofDim[Int](n, n)
    for (i <- 1 to n; j <- 1 to n) {
        table(i-1)(j-1) = i * j
    }
    val line = "=========================================="
    
    for (i <- 0 until n){
        println(table(i).map(num => f"$num%2d").mkString(" | "))
        if (i < n-1){
            println(line.mkString(""))
        }
    }
}