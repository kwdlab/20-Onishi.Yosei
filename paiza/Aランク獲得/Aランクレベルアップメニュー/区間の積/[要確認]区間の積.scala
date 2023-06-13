import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().split(" ").map(_.toLong)
    val numbers = readLine().split(" ").map(_.toLong)

    def whileMain(res: Long, start: Long, end: Long, product: Long): Long = {
        if (end >= n){
            return res
        } else {
            if (numbers(end.toInt) == 0) {
                whileMain(res, end+1, start, 1L)
            } else {
                def inner(res: Long, start: Long, product: Long): (Long, Long, Long) = {
                    if (product >= k && start <= end) {
                        inner(res.min(end - start + 1), start+1, product/numbers(start.toInt))
                    } else {
                        return (res, start, product)
                    }
                }
                val (newRes, newStart, newProduct) = inner(res, start, product * numbers(end.toInt))
                whileMain(newRes, newStart, end+1, newProduct)
            }
        }
    }
    println(whileMain(n+1, 0L, 0L, 1L))
}
//解答例使用済み