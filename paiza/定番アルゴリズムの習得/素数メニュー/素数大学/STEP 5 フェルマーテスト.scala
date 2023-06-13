import scala.io.StdIn._
import math._

object Main extends App {

    val N = readLine().toInt
    val a = 2

    val flag = if(N % a == 0){
        true
    }else if (pow(a, N-1) % N == 1){
        true
    } else {
        false
    }

    if (flag){
        println("YES")
    } else {
        println("NO")
    }
}