import scala.io.StdIn._

object Main extends App {

    val Array(n, m) = readLine().split(" ").map(_.toInt)
    val tmp = Array.fill(n)(readLine().trim().split(" "))

    val name = tmp.map(_(0))
    val price = tmp.map(_(1).toInt)
    val s = Array.fill(m)(readLine().trim())

    for (i <- s){
        if (name.contains(i)){
            println(price(name.indexOf(i)))
        } else {
            println(-1)
        }
    }
}
