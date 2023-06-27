import scala.io.StdIn._
import scala.collection.mutable.Stack

object Main extends App {
    
    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }
    var ans = 0
    val color = Array.fill(n)(-1)

    def dfs(start: Int, num: Int): Unit = {
        val stack = Stack[(Int, Int)]((start, num))
        while (stack.nonEmpty) {
            val (now, num) = stack.pop()
            if (color(now) == -1) {
                color(now) = num
                for (next <- graph(now)) {
                    stack.push((next, num))
                }
            }
        }
    }

    for (i <- 0 until n) {
        if (color(i) == -1) {
            dfs(i, ans)
            ans += 1
        }
    }
    println(ans)
}

//解答例使用済み
//再帰不可テストケースあり
//stackDFS
//Exception in thread "main" java.lang.StackOverflowError

/*
import scala.io.StdIn._

object Main extends App {
    
    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val graph = Array.fill(n)(List.empty[Int])
    for (_ <- 0 until m) {
        val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
        graph(a) = b :: graph(a)
        graph(b) = a :: graph(b)
    }

    var ans = 0
    val color = Array.fill(n)(-1)

    def dfs(now: Int, num: Int): Unit = {
        color(now) = num
        for (nxt <- graph(now)) {
            if (color(nxt) == -1) dfs(nxt, num)
        }
    }

    for (i <- 0 until n) {
        if (color(i) == -1){
            dfs(i, ans)
            ans += 1
        }
    }

    println(ans)
}

*/