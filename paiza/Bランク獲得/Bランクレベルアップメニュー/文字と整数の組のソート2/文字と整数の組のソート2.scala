import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val key = Array.ofDim[String](n)
    val value = Array.ofDim[Int](n)

    for (i <- 0 until n){
        val line = readLine.split(" ")
        if (key.contains(line(0))){
            value(key.indexOf(line(0))) = value(key.indexOf(line(0))) + line(1).toInt
        } else {
            key(i) = line(0)
            value(i) = line(1).toInt  
        }
    }
    
    val finval = value.sorted.reverse
    for (i <- finval){
        if (key(value.indexOf(i)) != null){
            println(key(value.indexOf(i)) + s" ${i}")
        }
    }
}
