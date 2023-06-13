import scala.io.StdIn._
import scala.collection.mutable.ArrayBuffer
import scala.collection.mutable.Map

object Main extends App {

    val treeMap: Map[Int, node] = Map.empty
    
    class node(val name: Int){
        val children = ArrayBuffer.empty[Int]

        def setChildren(x: Int) = {
            children += x
        }
    }

    val Array(n, k, r) = readLine().trim().split(" ").map(_.toInt)
    treeMap.put(r, new node(r))

    for (_ <- 1 until n){
        val Array(a, b) = readLine().trim().split(" ").map(_.toInt)
        if (!(treeMap.contains(a))){
            treeMap.put(a, new node(a))
        }
        treeMap(a).setChildren(b)
    }
    for (_ <- 0 until k){
        val v = readLine().trim().toInt
        if (treeMap.contains(v)){
            println(treeMap(v).children.sorted.mkString(" "))
        } else {
            println()
        }
    }
}
