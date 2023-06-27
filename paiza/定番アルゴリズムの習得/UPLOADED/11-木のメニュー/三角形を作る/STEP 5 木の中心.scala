import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val matrix = makeAdjacencyMatrix(n)    

    def makeAdjacencyMatrix(n: Int): Array[Array[Int]] = {
        val matrix = Array.fill[Int](n, n+1)(0)
        for (i <- 0 until n){
            matrix(i)(n) = i+1
        }
        for (_ <- 0 until n-1){
            val Array(a, b) = readLine().split(" ").map(_.toInt - 1)
            matrix(a)(b) = 1
            matrix(b)(a) = 1
        }
        matrix
    }

    @scala.annotation.tailrec
    def searchCenterNode(n: Int, matrix: Array[Array[Int]]): Array[Int] = {
        def removeMat(list: Array[Int], tmp: Array[Array[Int]]): Array[Array[Int]] = { //leafNodesの行と列を削除
            tmp.zipWithIndex 
            .filterNot(index => list.contains(index._2))
            .map { case (index, _) => index.zipWithIndex.filterNot(index => list.contains(index._2)).map(_._1) }
        }

        if (matrix.length <= 2) matrix.map(_.last)
        else {
            val leafNodes = matrix.zipWithIndex.filter(row => row._1.dropRight(1).sum == 1).map(_._2) //インデックス
            val newMatrix = removeMat(leafNodes, matrix)
            searchCenterNode(newMatrix.length, newMatrix)
        }
    }

    searchCenterNode(n, matrix).sorted.foreach(println)
}

/*
matrix
0 1 1 1 1 1
1 0 0 0 0 2
1 0 0 0 0 3
1 0 0 0 0 4
1 0 0 0 0 5

leafNodes
1 2 3 4
*/