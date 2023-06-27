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
