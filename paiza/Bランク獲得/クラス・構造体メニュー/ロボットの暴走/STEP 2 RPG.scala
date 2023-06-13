import scala.io.StdIn._

object Main extends App {

    class Hero(val states: Array[Int]){
        def levelup(h: String, a: String, d: String, s: String, c: String, f: String) = {
            states(0) = states(0) + 1
            states(1) = states(1) + h.toInt
            states(2) = states(2) + a.toInt
            states(3) = states(3) + d.toInt
            states(4) = states(4) + s.toInt
            states(5) = states(5) + c.toInt
            states(6) = states(6) + f.toInt
        }
        def muscle_training(h: String, a: String) = {
            states(1) = states(1) + h.toInt
            states(2) = states(2) + a.toInt
        }
        def running(d: String, s: String) = {
            states(3) = states(3) + d.toInt
            states(4) = states(4) + s.toInt
        }
        def study(c: String) = {
            states(5) = states(5) + c.toInt
        }
        def pray(f: String) = {
            states(6) = states(6) + f.toInt
        }
        def printout(){
            println(states.mkString(" "))
        }
    }

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val heroes: Array[Hero] = (0 until n).foldLeft(Array.empty[Hero]) { (heroes, _) =>
        val states = readLine().split(" ").map(_.toInt)
        heroes :+ new Hero(states)
    }

    for(i <- 0 until k){
        val j = readLine().split(" ")
        val heroId = j(0).toInt - 1
        val eventName = j(1)
        if (eventName == "levelup"){
            heroes(heroId).levelup(j(2), j(3), j(4), j(5), j(6), j(7))
        } else if (eventName == "muscle_training"){
            heroes(heroId).muscle_training(j(2), j(3))  
        } else if (eventName == "running"){
            heroes(heroId).running(j(2), j(3))   
        } else if (eventName == "study"){
            heroes(heroId).study(j(2))  
        } else if (eventName == "pray"){
            heroes(heroId).pray(j(2))
        }
    }

    for(i <- heroes){
        i.printout()
    }
}
