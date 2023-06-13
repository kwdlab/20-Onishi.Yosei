import scala.io.StdIn._

object Main extends App {

    val NXK = readLine().split(" ")
    val N = NXK(0).toLong
    val X = NXK(1).toLong
    val K = NXK(2).toLong

    if (K % 4 == 3) {
        println(2 * X * ((K - 4 * N) / 4) + X)
    } else {
        println(2 * X * ((K - 4 * N) / 4))
    }
}

//ループじゃどうやっても無理

/*
import scala.io.StdIn._

object Main extends App {

    val NXK = readLine().split(" ")
    val N = NXK(0).toInt
    val X = NXK(1).toInt
    val K = NXK(2).toInt
    val countLen =  Array.ofDim[Int](K)
    val left = Range(3, K+1, 4)
    val mid = Range(4, K+1, 4)

    val result = left.count(x => (x > N*4)) + mid.count(x => (x > N*4))
    println(result*X)
}

import scala.io.StdIn._

object Main extends App {

    val NXK = readLine().split(" ")
    val N = NXK(0).toInt
    val X = NXK(1).toInt
    val K = NXK(2).toInt
    val countLen =  Array.ofDim[Int](K)
    val left = Range(3, K+1, 4)
    val mid = Range(4, K+1, 4)

    for (i <- 0 until K){
        if (i+1 > 4*N && (left.contains(i+1) || mid.contains(i+1))){
            countLen(i) = X
        } else {
            countLen(i) = 0
        }
    }
    println(countLen.sum)
}
*/