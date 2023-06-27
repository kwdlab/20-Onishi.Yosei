import scala.io.StdIn._
import scala.collection.mutable.Map

object Main extends App {
    
    class Node(val name: Int, val children: List[Int]){

        def setChildren(x: Int): Node = {
            new Node(name, x :: children)
        }
    }

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    val treeMap: Map[Int, Node] = Map.empty
    treeMap.put(r, new Node(r, Nil))

    for (_ <- 1 until n){
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        if (!(treeMap.contains(a))) treeMap.put(a, new Node(a, Nil))
        treeMap.update(a, treeMap(a).setChildren(b))
    }
    for (_ <- 0 until k){
        val v = readLine().trim().toInt
        if (treeMap.contains(v)) println(treeMap(v).children.sorted.mkString(" "))
        else println()
    }
}
