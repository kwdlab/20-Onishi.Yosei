import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val Aline = Array.ofDim[Int](N, N)
    val Bline = Array.ofDim[Int](N, N)
    val Cline = Array.ofDim[Int](2, N)
    val result = Array.ofDim[Int](2*N+2)

    for (i <- 0 until N){
        Aline(i) = readLine().split(" ").map(_.toInt)
        result(i) = Aline(i).sum
    }
    for (i <- 0 until N; j <- 0 until N){
        Bline(i)(j) = Aline(j)(i)
    }
    for (i <- 0 until N){
        Cline(0)(i) = Aline(i)(i)
    }
    for (i <- 0 until N){
        Cline(1)(i) = Aline(i)(N-1-i)
    }

    for (i <- 0 until N){
        result(N+i) = Bline(i).sum
    }
    for (i <- 0 until 2){
        result(2*N+i) = Cline(i).sum
    }

    println(result.max)
}