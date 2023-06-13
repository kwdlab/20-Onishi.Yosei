import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().toInt
    val S = readLine().split("")
    val q = Stack[String]()

    for (i <- S){
        if (i == ")" && q.nonEmpty){
            val tmp = q.pop()
            if (tmp == ")"){
                q.push(tmp)
                q.push(i)
            }
        } else {
            q.push(i)
        }
    }
    if (q.nonEmpty){
        println("No")
    } else {
        println("Yes")
    }
}
