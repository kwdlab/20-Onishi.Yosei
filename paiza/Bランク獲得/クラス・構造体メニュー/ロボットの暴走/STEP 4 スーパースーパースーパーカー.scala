import scala.io.StdIn._
import scala.collection.mutable.Map

object Main extends App {

    class supercar(){
        val data: Map[String, Int] = Map("mile" -> 0, "l" -> 0, "f" -> 0)

        def setlf(x: Int, y: Int): Unit = {
            data("l") = x
            data("f") = y
        }
        def run() = {
            if (data("l") > 0){
                data("l") = data("l") - 1
                data("mile") = data("mile") + data("f")
            }
        }
        def fly() = {
            println()
        }
        def teleport() = {
            println()
        }
        def printOut() = {
            println(data("mile"))
        }
    }
    class supersupercar() extends supercar {

        override def fly() = {
            if (data("l") >= 5){
                data("l") = data("l") - 5
                data("mile") = data("mile") + data("f")*data("f")
            } else {
                run()
            }
        }
    }
    class supersupersupercar() extends supersupercar {

        override def fly() = {
            if (data("l") >= 5){
                data("l") = data("l") - 5
                data("mile") = data("mile") + 2*data("f")*data("f")
            } else {
                run()
            }
        }
        override def teleport() = {
            if (data("l") >= data("f")*data("f")){
                data("l") = data("l") - data("f")*data("f")
                data("mile") = data("mile") + data("f")*data("f")*data("f")*data("f")
            } else {
                fly()
            }
        }
    }
    
    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    val cars: Array[supercar] = (0 until n).foldLeft(Array.empty[supercar]) { (cars, _) =>
        val spec = readLine().trim().split(" ")
        val car = spec(0) match {
            case "supercar" => new supercar()
            case "supersupercar" => new supersupercar()
            case "supersupersupercar" => new supersupersupercar()
        }
        car.setlf(spec(1).toInt, spec(2).toInt)
        cars :+ car
    }

    for(i <- 0 until k){
        val j = readLine().split(" ")
        val index = j(0).toInt - 1
        val func = j(1)

        if (func == "run"){
            cars(index).run()
        } else if (func == "fly"){
            cars(index).fly()
        } else if (func == "teleport"){
            cars(index).teleport()
        }
    }
    
    cars.foreach(_.printOut)
}
