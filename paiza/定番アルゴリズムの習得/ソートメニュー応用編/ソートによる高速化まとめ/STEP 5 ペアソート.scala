import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val a = Array.ofDim[(Int, Int)](n)

    for (i <- 0 until n){
        val line = readLine().split(" ").map(_.toInt)
        a(i) = (line(0), line(1))
    }

    def withSort(x: Array[(Int, Int)]): Array[(Int, Int)] = {
        val tmp = x.sortWith {
            case ((key1, value1), (key2, value2)) => {
                if (key1 != key2) {
                    key1 < key2
                } else {
                    value1 < value2
                }
            } 
        }
        return tmp
    }

    val result = withSort(a)
    for ((i, j) <- result){
        println(s"${i} ${j}")
    }
}
