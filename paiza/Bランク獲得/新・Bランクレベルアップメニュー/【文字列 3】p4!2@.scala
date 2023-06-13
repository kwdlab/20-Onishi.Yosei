import scala.io.StdIn._

object Main extends App {

    val s = readLine()

    def leet(s : String) : Boolean = {
        val tmp = s.split("")
        val fromTo = Array(Array("4", "a"), Array("@", "a"), Array("1", "i"), Array("!", "i"), Array("2", "z"))

        def replace(cnt: Int, sen: Array[String]) : Array[String] = {
            if (cnt == fromTo.length){
                return sen
            } else {
                val result: Array[String] = (0 until sen.length).foldLeft(Array.empty[String]) { (array, i) =>
                    if (sen(i) == fromTo(cnt)(0)){
                        array :+ fromTo(cnt)(1)
                    } else {
                        array :+ sen(i)
                    }
                }
                replace(cnt+1, result)
            }
        }

        val line = replace(0, tmp)        
        if (line.mkString("").contains("paiza")){
            return true
        } else {
            return false
        }
    }

    if (s.contains("paiza")){
        println("paiza")
    } else if (leet(s)){
        println("leet")
    } else {
        println("nothing")
    }
}