import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().toInt
    val an = readLine().split(" ")

    def safetoInt(x: String): Boolean = {
        try {
            x.toInt
            true
        } catch {
            case _: NumberFormatException => false
        }
    }

    val q = Stack[Int]()
    var sum = 0
    for (i <- an){
        safetoInt(i) match {
            case true => q.push(i.toInt)
            case false => i match {
                case "+" => {
                    val num1 = q.pop()
                    val num2 = q.pop()
                    q.push(num2 + num1)
                }
                case "-" => {
                    val num1 = q.pop()
                    val num2 = q.pop()
                    q.push(num2 - num1)
                }
            }
        }
    }
    println(q.pop())
}
//解答例使用済み