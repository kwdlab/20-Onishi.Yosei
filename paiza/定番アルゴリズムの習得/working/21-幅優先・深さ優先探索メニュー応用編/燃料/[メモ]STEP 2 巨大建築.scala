import scala.io.StdIn._

object Main extends App {
 
    val n = readLine().trim().toInt
    val recipe = Array.fill(n)(readLine().trim().split(" ").map(_.toInt))
    val price = recipe.map(_(0).toLong)
    val enable = recipe.map(_(1))
    val parts = Array.fill(n)(List.empty[Int])
    val minValue = price

    for (i <- 0 until n; j <- 0 until enable(i)) {
        parts(i) = recipe(i)(j + 2) - 1 :: parts(i)
    }

    def dfs(now: Int): Long = {
        if (parts(now).nonEmpty) {
            val purchase = parts(now).map(next => dfs(next)).sum
            minValue(now) = purchase.min(minValue(now))
        }
        minValue(now)
    }

    dfs(0)
    println(minValue(0))
}


//Exception in thread "main" java.lang.StackOverflowError
//再帰は無理
//軽い入力に対しては動作することを確認

/*
import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {
 
    val n = readLine().trim().toInt
    val recipe = Array.fill[Array[Int]](n)(readLine().trim().split(" ").map(_.toInt))
    val price = recipe.map(_(0).toLong)
    val enable = recipe.map(_(1))
    val parts = Array.fill(n)(List.empty[Int])
    val minValue = price
    val confirm = Array.fill(n)(false)

    for (i <- 0 until n; j <- 0 until enable(i)) {
        parts(i) = recipe(i)(j + 2) - 1 :: parts(i)
    }

    def dfs(start: Int): Long = {
        val stack = Stack[Int]()
        parts(start).foreach(i => stack.push(i))

        while (stack.nonEmpty){
            val now = stack.pop()
            if (confirm(now)){

            } else if (parts(now).isEmpty){
                confirm(now) = true
            } else {
                for (next <- parts(now)){
                    if (parts(next).isEmpty && !confirm(next)) confirm(next) = true
                    if (!confirm(next)) stack.push(next)
                }
                if (parts(now).forall(next => confirm(next))){
                    val purchase = parts(now).map(next => minValue(next)).sum
                    minValue(now) = purchase.min(price(now))
                    confirm(now) = true
                }
            }
        }
        if (parts(0).forall(next => confirm(next))){
            val purchase = parts(0).map(next => minValue(next)).sum
            purchase.min(price(0))
        } else {
            dfs(0)
        }
    }

    val result = dfs(0)
    println(result)
}
*/