import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {

    val n = readLine().trim().toInt
    val recipe = Array.fill(n)(readLine().trim().split(" ").map(_.toInt))
    val price = recipe.map(_(0).toLong)
    val num = recipe.map(_(1).toInt)
    val parts = Array.fill[List[Int]](n)(Nil)
    val minValue = Array.fill[Long](n)(Long.MaxValue)
    val confirm = Array.fill[Boolean](n)(false)

    for (i <- 0 until n) {
        parts(i) = recipe(i).drop(2).map(_ - 1).toList
        if (num(i) == 0) {
            confirm(i) = true
            minValue(i) = price(i)
        }
    }

    def dfs(start: Int): Unit = {
        val stack = Stack[Int](start)

        while (stack.nonEmpty) {
            val now = stack.top
            if (parts(now).forall(confirm)) {
                val purchase = parts(now).map(next => minValue(next)).sum
                minValue(now) = purchase.min(minValue(now))
                stack.pop()
            } else {
                val next = parts(now).find(!confirm(_)).getOrElse(-1)
                if (next != -1) {
                    stack.push(next)
                    confirm(next) = true
                }
            }
        }
    }

    dfs(0)
    println(minValue(0))
}

//再帰限界テストケースあり