import scala.io.StdIn._

object Main extends App {

    val Array(n, k) = readLine().trim().split(" ").map(_.toInt)
    val tmp = Array.fill(n)(readLine().trim().split(" "))

    val keyList = tmp.map(_(0))
    val bankData: Map[String, (String, Long)] = (0 until n).map 
    { i =>
        val Array(c, p, d) = tmp(i)
        c -> (p, d.toLong)
    }.toMap
    val opList = Array.fill(k)(readLine().trim().split(" "))

    def bankDB(cnt: Int, bankData: Map[String, (String, Long)]): Map[String, (String, Long)] = {
        if (cnt == k){
            return bankData
        } else {
            val ID = opList(cnt)(0)
            val Pass = opList(cnt)(1)
            val Cash = opList(cnt)(2).toLong

            val newDB = {
                if ((bankData(ID)._1) == Pass){
                    bankData ++ Map(ID -> (bankData(ID)._1, bankData(ID)._2 - Cash))
                } else {
                    bankData
                }
            }
            bankDB(cnt+1, newDB)
        }
    }
    val result = bankDB(0, bankData)
    for (i <- keyList){
        println(s"${i} ${result(i)._2}")
    }
}