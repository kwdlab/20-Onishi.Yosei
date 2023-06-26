import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)
    val q = Stack[Int]()
    
    for (i <- An){
        q.push(i)
        var flag = true
        while (q.length > 1 && flag){
            val top = q.pop()
            val bottom = q.pop()
            if (top == bottom){
                q.push(top+bottom)
            } else {
                q.push(bottom)
                q.push(top)
                flag = false
            } 
        }
    }

    while (q.nonEmpty){
        println(q.pop())
    }
}
