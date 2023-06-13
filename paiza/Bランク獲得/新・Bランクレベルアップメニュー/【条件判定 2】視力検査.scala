import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val tmp = Array.fill(n)( readLine().trim().split(" "))
    val TA = tmp.collect { case Array("TA", value) => value }.toArray
    val TB = tmp.collect { case Array("TB", value) => value }.toArray
    val TC = tmp.collect { case Array("TC", value) => value }.toArray
    val TD = tmp.collect { case Array("TD", value) => value }.toArray

    def testFunction(test: Array[String], ok: Int, ng: Int) : Int = {
        if (ok == 2 && ng < 2){
            return 1
        } else if (ok + ng == test.length){
            return 0
        } else {
            val i = test(ok+ng)
            if (i == "ok"){
                testFunction(test, ok+1, ng)
            } else if(i == "ng"){
                testFunction(test, ok, ng+1)
            } else {
                return -1
            }
        }
    }
    def printOut(rA:Int, rB:Int, rC:Int, rD:Int) = {
        if (rA == 1){
            println("A")
        } else if (rB == 1){
            println("B")
        } else if (rC == 1){
            println("C")
        } else if (rD == 1){
            println("D")
        } else {
            println("E")
        }
    }

    printOut(testFunction(TA, 0, 0), testFunction(TB, 0, 0), testFunction(TC, 0, 0), testFunction(TD, 0, 0))
}