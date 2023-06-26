import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().trim().toInt
    val X = Stack[Int]()
    for (_ <- 0 until n){
        X.push(readLine().trim().toInt)
    }
    val k = readLine().trim().toInt

    for (_ <- 0 until k){
        val q = readLine().split(" ")
        q(0) match {
            case "return" => X.push(q(1).toInt)
            case "rent" => X.pop()
        }
    }

    while (X.nonEmpty){
        println(X.pop())
    }
}