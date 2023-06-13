import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val data = Array.ofDim[Long](101, 2)
    val calK = Array.ofDim[Int](n)
    val Krange = Array.ofDim[Int](n-1, 2)

    for (i <- 0 until n){
        val input = readLine().split(" ")
        val key = input(0).toInt
        val y = input(1).toLong
        val x = input(2).toLong
        
        data(key) = Array(y, x)
        calK(i) = key
    }
    for (i <- 0 until n-1){
        if (!(calK(i)+1 == calK(i+1))){
            Krange(i) = Array(calK(i), calK(i+1))            
        }
    }

    for (i <- Krange){
        if (i(0) == 0 && i(1) == 0){

        } else {
            val start = i(0)
            val end = i(1)

            val ydelta = (data(end)(0) - data(start)(0)) / (end - start).toDouble
            val xdelta = (data(end)(1) - data(start)(1)) / (end - start).toDouble
            var count = 0

            for (j <- start+1 until end){
                count = count + 1
                data(j)(0) = data(start)(0) + (count * ydelta).toLong
                data(j)(1) = data(start)(1) + (count * xdelta).toLong
            }            
        }
    }

    def printout() = {
        for (i <- data){
            println(i.mkString(" "))
        }
    }
    printout()
}
