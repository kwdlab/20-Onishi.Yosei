import scala.io.StdIn._

object Main extends App {

    val N = readLine().toInt
    val S = readLine()
    val Slen = S.length
    val Sfront = S.split("").take((Slen/2.0).ceil.toInt).mkString("")
    val Srear = S.split("").drop((Slen/2.0).floor.toInt).mkString("")

    for (i <- 0 until N){
        val V = readLine()
        val Vlen = V.length
        if (V == S){
            println("banned")

        } else if (Vlen == Slen && (V.contains(Sfront) || V.contains(Srear))){

            if (V.contains(Sfront)){
                val Vrear = V.split("").drop((Vlen/2.0).ceil.toInt).mkString("")
                var text = ""a
                for (j <- 0 until Sfront.length){
                    text = text + "x"
                }
                println(text + Vrear)

            } else if (V.contains(Srear)){
                val Vfront = V.split("").take((Vlen/2.0).floor.toInt).mkString("")
                var text = ""
                for (j <- 0 until Sfront.length){
                    text = text + "x"
                }
                println(Vfront + text)
            }

        } else {
            println(V)
        }
    }
}