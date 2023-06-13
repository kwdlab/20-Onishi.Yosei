import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val an = readLine().split(" ").map(_.toInt)

    val line = an.sliding(k).toList
    val sumLine = Array.ofDim[Int](line.length)
    for (i <- 0 until line.length){
        sumLine(i) = line(i).sum
    }
    println(sumLine.indexOf(sumLine.max)+1)
}
