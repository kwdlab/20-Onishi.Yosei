import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().trim().split(" ").map(_.toInt)
    val a = readLine().trim().split(" ").map(_.toInt)
    val add = Array.fill(n+1)(0)

    for (_ <- 0 until m){
        val Array(l, u, a) = readLine().trim().split(" ").map(_.toInt)

        add(l-1) = add(l-1) + a
        add(u) = add(u) - a
    }
    
    for (i <- 0 until n){
        println(a(i)+add(i))
        if (i+1 < n+1){
            add(i+1) = add(i+1) + add(i)
        }
    }
}
//解答例使用済み
