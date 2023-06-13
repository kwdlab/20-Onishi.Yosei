import scala.io.StdIn._

object Main extends App {
    
    val NK = readLine().split(" ").map(_.toInt)
    val N = NK(0)
    val K = NK(1)
    val Sn = Array.ofDim[Int](N+1)

    Sn(0) = 0
    for(i <- 1 to N){
        Sn(i) = readLine().toInt
    }

    for(i <- 0 until K){
        val lr = readLine().split(" ").map(_.toInt)
        val Al = lr(0)
        val Ar = lr(1)
        val Bl = lr(2)
        val Br = lr(3)

        val Achoice = Sn.take(Ar+1).drop(Al)
        val Bchoice = Sn.take(Br+1).drop(Bl)

        if (Achoice.max - Achoice.min > Bchoice.max - Bchoice.min){
            println("A")
        } else if (Achoice.max - Achoice.min < Bchoice.max - Bchoice.min){
            println("B")
        } else {
            println("DRAW")
        }        
    }
}
