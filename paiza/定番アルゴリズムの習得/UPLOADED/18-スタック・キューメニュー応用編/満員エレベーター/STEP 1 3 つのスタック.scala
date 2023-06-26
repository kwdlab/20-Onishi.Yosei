import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().toInt
    val A = Stack[Int]()
    val B = Stack[Int]()
    val C = Stack[Int]()

    for (_ <- 0 until n){
        val i = readLine().split(" ")
        i(0) match {
            case "push" => i(1) match {
                case "1" => A.push(i(2).toInt)
                case "2" => B.push(i(2).toInt)
                case "3" => C.push(i(2).toInt)
            }
            case "pop" => i(1) match {
                case "1" => A.pop()
                case "2" => B.pop()
                case "3" => C.pop()
            }
        }
    }
    while (A.nonEmpty){
        println(A.pop())
    }
    while (B.nonEmpty){
        println(B.pop())
    }
    while (C.nonEmpty){
        println(C.pop())
    }
}