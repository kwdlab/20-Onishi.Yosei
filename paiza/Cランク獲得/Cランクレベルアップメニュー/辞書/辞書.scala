import scala.io.StdIn._

object Main extends App {

    val Array(p, q, r) = readLine().split(" ").map(_.toInt)

    val ijMap: Map[Int, Int] = (0 until p).foldLeft(Map.empty[Int, Int]) { (map, _) =>
        val tmp = readLine.split(" ").map(_.toInt)
        map + (tmp(0) -> tmp(1))
    }
    val jkMap: Map[Int, Int] = (0 until q).foldLeft(Map.empty[Int, Int]) { (map, _) =>
        val tmp = readLine.split(" ").map(_.toInt)
        map + (tmp(0) -> tmp(1))
    }

    for (i <- 1 to p){
        println(s"${i} ${jkMap(ijMap(i))}")
    }
}

//https://gside.org/articles/scala/map/