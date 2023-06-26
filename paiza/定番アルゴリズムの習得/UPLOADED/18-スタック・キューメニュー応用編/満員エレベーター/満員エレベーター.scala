import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val Array(n, x) = readLine().split(" ").map(_.toInt)
    val Q = Stack[Int]()

    for (_ <- 0 until n){
        val q = readLine().split(" ")
        q(0) match {
            case "ride" => {
                for (i <- 2 until 2+q(1).toInt){
                    Q.push(q(i).toInt)
                    if (Q.sum > x){
                        Q.pop()
                    }
                }
            }
            case "get_off" => {
                for (i <- 0 until q(1).toInt){
                    Q.pop()
                }
            }
        }
    }

    println(Q.length)
    println(Q.sum)
}