import scala.io.StdIn._

object Main extends App {

    val k = readLine().toInt
    val s = Array("S_1","S_2","S_3","S_4","S_5","S_6","S_7","S_8","S_9","S_10","S_11","S_12","S_13")
    val h = Array("H_1","H_2","H_3","H_4","H_5","H_6","H_7","H_8","H_9","H_10","H_11","H_12","H_13")
    val d = Array("D_1","D_2","D_3","D_4","D_5","D_6","D_7","D_8","D_9","D_10","D_11","D_12","D_13")
    val c = Array("C_1","C_2","C_3","C_4","C_5","C_6","C_7","C_8","C_9","C_10","C_11","C_12","C_13")
    val card = s ++ h ++ d ++ c

    def shuffle(cnt: Int, x: Array[String]): Array[String] = {
        if (cnt == k){
            return x
        } else {
            val card = x.reverse
            val tmp = Array.ofDim[String](52)

            def cardLoop(cnt: Int, lower: Int, upper: Int): Unit = {
                if (cnt == 52){
                    return
                } else {
                    if (cnt % 2 == 0){
                        tmp(cnt) = card(lower)
                        cardLoop(cnt+1, lower - 1, upper)
                    } else {
                        tmp(cnt) = card(upper)
                        cardLoop(cnt+1, lower, upper - 1)
                    }
                }
            }
            cardLoop(0, 51, 25)
            shuffle(cnt+1, tmp)
        }
    }

    val result = shuffle(0, card)
    result.foreach(println)
}