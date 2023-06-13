import scala.io.StdIn._

object Main extends App {
    var answer = 0
    var add = 0
    val s = Array.ofDim[Int](10) //1 start
    val b = Array.ofDim[Int](10, 5) //1 start

    s(0) = 0
    for (i <- 1 to 7 by 3){
        val tmp = readLine().split(" ").map(_.toInt)
        answer = answer + tmp.sum
        s(i) = tmp(0)
        s(i+1) = tmp(1)
        s(i+2) = tmp(2)
    }
    for(i <- 1 to 9){
        b(i) = Array(0) ++ readLine().split(" ").map(_.toInt)
    }

    for (i <- (1 to 9).permutations){
        var panelTF = Array.fill(10)(false)
        var tmp = 0

        for (panelNum <- i){
            val bingoLine : Int = panelNum match {
                case 1 => {
                        (if (panelTF(2) && panelTF(3)){ 1 } else { 0 }) + 
                        (if (panelTF(4) && panelTF(7)){ 1 } else { 0 }) + 
                        (if (panelTF(5) && panelTF(9)){ 1 } else { 0 })
                    }
                case 2 => {
                        (if (panelTF(1) && panelTF(3)){ 1 } else { 0 }) + 
                        (if (panelTF(5) && panelTF(8)){ 1 } else { 0 }) 
                    }
                case 3 => {
                        (if (panelTF(1) && panelTF(2)){ 1 } else { 0 }) + 
                        (if (panelTF(6) && panelTF(9)){ 1 } else { 0 }) + 
                        (if (panelTF(5) && panelTF(7)){ 1 } else { 0 })
                    }
                case 4 => {
                        (if (panelTF(1) && panelTF(7)){ 1 } else { 0 }) + 
                        (if (panelTF(5) && panelTF(6)){ 1 } else { 0 })
                    }
                case 5 => {
                        (if (panelTF(1) && panelTF(9)){ 1 } else { 0 }) + 
                        (if (panelTF(3) && panelTF(7)){ 1 } else { 0 }) + 
                        (if (panelTF(2) && panelTF(8)){ 1 } else { 0 }) + 
                        (if (panelTF(4) && panelTF(6)){ 1 } else { 0 })
                    }
                case 6 => {
                        (if (panelTF(3) && panelTF(9)){ 1 } else { 0 }) + 
                        (if (panelTF(4) && panelTF(5)){ 1 } else { 0 })
                    }
                case 7 => {
                        (if (panelTF(1) && panelTF(4)){ 1 } else { 0 }) + 
                        (if (panelTF(3) && panelTF(5)){ 1 } else { 0 }) + 
                        (if (panelTF(8) && panelTF(9)){ 1 } else { 0 })
                    }
                case 8 => {
                        (if (panelTF(2) && panelTF(5)){ 1 } else { 0 }) + 
                        (if (panelTF(7) && panelTF(9)){ 1 } else { 0 })
                    }
                case 9 => {
                        (if (panelTF(3) && panelTF(6)){ 1 } else { 0 }) + 
                        (if (panelTF(7) && panelTF(8)){ 1 } else { 0 }) + 
                        (if (panelTF(1) && panelTF(5)){ 1 } else { 0 })
                    }
            }
            if (0 < bingoLine){
                tmp = tmp + b(panelNum)(bingoLine)
            }
            panelTF(panelNum) = true
        }
        add = Array(add, tmp).max
    }
    println(answer + add)
}