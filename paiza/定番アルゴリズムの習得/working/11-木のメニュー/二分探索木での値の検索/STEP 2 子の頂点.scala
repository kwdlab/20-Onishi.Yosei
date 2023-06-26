import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object Main extends App {

    val treeMap: Map[Int, node] = Map.empty
    
    class node(val name: Int){
        val children = ArrayBuffer.empty[Int]
        val parents = ArrayBuffer.empty[Int]

        def setChildren(x: Int) = {
            children += x 
        }
        def setParents(x: Int) = {
            parents += x
        }
        def getChildren(index: Int):Int = {
            return children(index-1)
        }
    }

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    treeMap.put(r, new node(r))

    for (_ <- 1 until n){
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        if (!(treeMap.contains(a))){
            treeMap.put(a, new node(a))
        }
        if (!(treeMap.contains(b))){
            treeMap.put(b, new node(b))
        }
        treeMap(a).setChildren(b)
        treeMap(b).setParents(a)
    }
    for (_ <- 0 until k){
        val Array(v, k) = readLine().trim().split(" ").map(_.toInt)
        if (treeMap.contains(v)){
            println(treeMap(v).getChildren(k))
        } else {
            println()
        }
    }
}
