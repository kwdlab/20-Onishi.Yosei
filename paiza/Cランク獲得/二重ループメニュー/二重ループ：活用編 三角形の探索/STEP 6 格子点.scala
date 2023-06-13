import math._

object Main extends App {

    val value = Array.ofDim[Int](100000)
    val index = Array.ofDim[String](100000)

    for (i <- 1 to 100; j <- 1 to 100) {
        if (i+j < 100 && pow(i, 3) + pow(j, 3) < 100000){
            value(i*j) = i * j
            index(i*j) = s"${i} ${j}"
        }
    }
    val line = index(value.indexOf(value.max)).split(" ").map(_.toInt)
    println(line(0) * line(1))
}