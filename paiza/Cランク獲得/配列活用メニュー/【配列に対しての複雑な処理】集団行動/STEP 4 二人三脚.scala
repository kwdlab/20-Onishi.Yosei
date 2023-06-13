import scala.io.StdIn._
import scala.collection.mutable.ArrayDeque

object Main extends App {

    val n = readLine().toInt
    val a = Array.ofDim[Int](n)
    val rr = ArrayDeque[Int]()
    val re = ArrayDeque[String]()

    for (i <- 0 until n){
        a(i) = readLine().toInt
    }

    for (i <- 0 until n; j <- 1 until n){
        if (i < j){
            val (com1, com2) = {
                if (a(i) > a(j)){
                    (a(j), a(i))
                } else {
                    (a(i), a(j))
                }
            }
            rr.append(com2 - com1)
            re.append(s"${com1} ${com2}")
        }
    }

    val index = rr.indexOf(rr.min)
    for (i <- re(index).split(" ")){
        println(i)
    }
}