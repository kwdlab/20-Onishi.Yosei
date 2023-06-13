import scala.io.StdIn._

object Main extends App {
    
    val HW = readLine().split(" ").map(_.toInt)
    val H = HW(0)
    val W = HW(1)
    val Sh = Array.ofDim[String](H, W)

    for(i <- 0 until H){
        Sh(i) = readLine().split("")
    }

    def TrueFalse(y: Int, x: Int) : Boolean = {
        if (Sh(y)(x) == "#"){ true }
        else { false }
    }
    def LeftRight(y: Int, x: Int) : Boolean = { 
        if (0 < x && x < W-1){
            if (TrueFalse(y, x-1) && TrueFalse(y, x+1)){ true }
            else { false } 

        } else if (x == 0){
            if (TrueFalse(y, x+1)){ true }
            else { false } 

        } else if (x == W-1){
            if (TrueFalse(y, x-1)){ true }
            else { false } 
          
        } else { false } 
    }
    def UpDown(y: Int, x: Int) : Boolean = { 
        if (0 < y && y < H-1){
            if (TrueFalse(y+1, x) && TrueFalse(y-1, x)){ true }
            else { false } 

        } else if (y == 0){
            if (TrueFalse(y+1, x)){ true }
            else { false } 

        } else if (y == H-1){
            if (TrueFalse(y-1, x)){ true }
            else { false } 
          
        } else { false } 
    }

    for (i <- 0 until H; j <- 0 until W){
        if (LeftRight(i, j) && UpDown(i, j)){ println(s"${i} ${j}") }
    }
}
