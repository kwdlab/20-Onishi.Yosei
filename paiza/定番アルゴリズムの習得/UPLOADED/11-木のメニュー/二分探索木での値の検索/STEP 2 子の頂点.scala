import scala.io.StdIn._
import scala.collection.mutable.Map

object Main extends App {
    
    class Node(val name: Int, val children: List[Int], val parents: List[Int]){

        def setChildren(x: Int): Node = {
            new Node(name, x :: children, parents)
        }
        def setParents(x: Int): Node = {
            new Node(name, children, x :: parents)
        }
        def getChildren(index: Int):Int = {
            children.reverse(index-1)
        }
    }

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    val treeMap: Map[Int, Node] = Map.empty
    treeMap.put(r, new Node(r, Nil, Nil))

    for (_ <- 1 until n){
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        if (!(treeMap.contains(a))) treeMap.put(a, new Node(a, Nil, Nil))
        if (!(treeMap.contains(b))) treeMap.put(b, new Node(b, Nil, Nil))
        treeMap.update(a, treeMap(a).setChildren(b))
        treeMap.update(b, treeMap(b).setParents(a))
    }
    for (_ <- 0 until k){
        val Array(v, k) = readLine().trim().split(" ").map(_.toInt)
        if (treeMap.contains(v)) println(treeMap(v).getChildren(k))
        else println()
    }
}