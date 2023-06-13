import scala.io.StdIn._
import scala.collection.mutable.Map

object Main extends App {

    class robot1(){
        val data: Map[String, Int] = Map("level" -> 0, "w" -> 0, "h" -> 0, "step" -> 0)

        def initialSet(level: Int, w: Int, h: Int) = {
            data("level") = level
            data("w") = w
            data("h") = h
        }

        def levelStep() = {
            if (data("level") == 1){
                data("step") = 1
            } else if (data("level") == 2){
                data("step") = 2
            } else if (data("level") == 3){
                data("step") = 5
            } else if (data("level") == 4){
                data("step") = 10
            }
        }
        def move(dir: String) = {
            levelStep()
            if (dir == "N"){
                data("h") = data("h") - data("step")
            } else if (dir == "S"){
                data("h") = data("h") + data("step")
            } else if (dir == "E"){
                data("w") = data("w") + data("step")
            } else if (dir == "W"){
                data("w") = data("w") - data("step")
            }
            conflict()
        }
        def conflict() = {
            for (i <- boxes){
                if (i(0) == data("w") && i(1) == data("h")){
                    data("level") = data("level") + 1
                    if (data("level") > 4){
                        data("level") = 4
                    }
                }
            }
        }
        def printOut() = {
            println(s"${data("w")} ${data("h")} ${data("level")}")
        }
    }

    val Array(h, w, n, k) = readLine().trim().split(" ").map(_.toInt)
    val boxes = Array.fill(10)(readLine().split(" ").map(_.toInt)) 
    val robots: Array[robot1] = (0 until n).foldLeft(Array.empty[robot1]) { (robots, _) =>
        val data = readLine().split(" ").map(_.toInt)
        val robot = new robot1()
        robot.initialSet(data(2), data(0), data(1))
        robots :+ robot
    }

    for(i <- 0 until k){
        val rd = readLine().split(" ")
        robots(rd(0).toInt-1).move(rd(1))
    }
    
    robots.foreach(_.printOut)
}
