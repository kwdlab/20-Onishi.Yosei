import scala.io.StdIn

object Main extends App {

    val n = StdIn.readLine().toInt
    val Array(a, b) = StdIn.readLine().split(" ").map(_.toInt)

    def loop(times: Int, kyoko: Int, paiza: Int): Int = {
        val newKyoko = kyoko + paiza * a
        if (newKyoko > n) {
            return times+1
        }
        val newPaiza = paiza + newKyoko % b
        loop(times+1, newKyoko, newPaiza)   
    }

    println(loop(0, 1, 1))
}