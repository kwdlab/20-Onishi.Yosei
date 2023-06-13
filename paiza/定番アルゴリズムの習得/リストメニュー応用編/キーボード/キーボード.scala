import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer

object Main extends App {

    def operationKeyboard(): Unit = {
        val n = readLine().toInt
        val op = readLine().split(" ")
        val line = ArrayBuffer[String]()
        var index = 0

        for (i <- op){
            i match {
                case "Left" => {
                    if(index != 0){
                        index = index - 1
                    }
                }
                case "Right" => {
                    if(index != line.length){
                        index = index + 1
                    }
                }
                case "Delete" => {
                    if(index != 0 && line.nonEmpty){
                        line.remove(index-1)
                        index = index - 1
                    }
                }
                case _ => {
                    line.insert(index, i)
                    index = index + 1
                }
            }
        }
        println(line.mkString(" "))
    }

    operationKeyboard()
}