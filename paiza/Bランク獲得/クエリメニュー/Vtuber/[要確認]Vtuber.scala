import scala.io.StdIn._

object Main extends App {
     
    val n = readLine().toInt
    val tmp = Array.fill(n)(readLine().trim().split(" "))
    val members = tmp.collect { case Array(name, "join", _) => name }

    val superchat: Map[String, Long] = (0 until n).foldLeft(Map.empty[String, Long]) { (map, i) =>
        val name = tmp(i)(0)
        val select = tmp(i)(1)
        if (select == "give") {
            val amount = tmp(i)(2).toLong
            map + (name -> (map.getOrElse(name, 0L) + amount))
        } else {
            map
        }
    }
    def withSort(x: Map[String, Long]) : Seq[(String, Long)] = {
        val tmp = x.toSeq.sortWith {
            case ((name1, amount1), (name2, amount2)) => {
                if (amount1 != amount2) {
                    amount1 > amount2
                } else {
                    name1 > name2
                }
            } 
        }
        return tmp
    }

    val result = withSort(superchat)
    result.foreach { case (name, _) => println(name) }
    members.sorted.foreach(println)
}
//sortWithは安心