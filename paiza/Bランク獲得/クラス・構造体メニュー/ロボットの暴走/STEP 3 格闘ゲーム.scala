import scala.io.StdIn._

object Main extends App {

    class Hero(val states: Array[Int]){
        //HP //F1 //A1 //F2 //A2 //F3 //A3

        def getF(x : Int) : Int = {
            if(x == 1){
                states(1)
            } else if(x == 2){
                states(3)
            } else if(x == 3){
                states(5)
            } else {
                0
            }
        }
        def getA(x : Int) : Int = {
            if(x == 1){
                states(2)
            } else if(x == 2){
                states(4)
            } else if(x == 3){
                states(6)
            } else {
                0
            }
        }
        def powerUp() = {
            def setF1() = {
                if (states(1) - 3 < 1){
                    states(1) = 1
                } else {
                    states(1) = states(1) - 3
                }
                states(2) = states(2) + 5
            }
            def setF2() = {
                if (states(3) - 3 < 1){
                    states(3) = 1
                } else {
                    states(3) = states(3) - 3
                }
                states(4) = states(4) + 5
            }
            def setF3() = {
                if (states(5) - 3 < 1){
                    states(5) = 1
                } else {
                    states(5) = states(5) - 3
                }
                states(6) = states(6) + 5
            }

            if (states(1) == 0 && states(2) == 0){
                setF2()
                setF3()
            }else if (states(3) == 0 && states(4) == 0){
                setF1()
                setF3()
            }else if (states(5) == 0 && states(6) == 0){
                setF1()
                setF2()
            }
        }
        def damage(x : Int) = {
            states(0) = states(0) - x
        }
        def alive() : Boolean = {
            if (states(0) > 0){
                true
            } else {
                false
            }
        }
        def printout() = {
            println(s"${states(0)} / ${states(1)} ${states(2)} ${states(3)} ${states(4)} ${states(5)} ${states(6)}")
        }
    }

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val heroes: Array[Hero] = (0 until n).foldLeft(Array.empty[Hero]) { (heroes, _) =>
        val states = readLine().split(" ").map(_.toInt)
        heroes :+ new Hero(states)
    }

    for(i <- 0 until k){
        val j = readLine().split(" ").map(_.toInt)
        val p1 = j(0) - 1
        val t1 = j(1)
        val p2 = j(2) - 1
        val t2 = j(3)

        if (heroes(p1).alive && heroes(p2).alive){
            if (heroes(p1).getF(t1) == 0 && heroes(p1).getA(t1) == 0 && heroes(p2).getF(t2) == 0 && heroes(p2).getA(t2) == 0){
                heroes(p1).powerUp
                heroes(p2).powerUp
            } else {
                if (heroes(p1).getF(t1) == 0 && heroes(p1).getA(t1) == 0){
                    heroes(p1).powerUp
                    heroes(p1).damage(heroes(p2).getA(t2))
                } 
                else if (heroes(p2).getF(t2) == 0 && heroes(p2).getA(t2) == 0) {
                    heroes(p2).powerUp
                    heroes(p2).damage(heroes(p1).getA(t1))
                } 
                else if(heroes(p1).getF(t1) < heroes(p2).getF(t2)){
                    heroes(p2).damage(heroes(p1).getA(t1))
                } 
                else if(heroes(p1).getF(t1) > heroes(p2).getF(t2)){
                    heroes(p1).damage(heroes(p2).getA(t2))  
                }
            }
        }
    }
    println(heroes.count(_.alive))
}
