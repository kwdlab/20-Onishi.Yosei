import scala.io.StdIn._

object Main extends App {

    def operationShuffle(opList: Array[(Int, Int, Int)], n: Int): Int = {
        var cups = List.fill[Boolean](n)(false)
        cups = true :: cups.tail

        for ((op, x, y) <- opList) {
            val xIndex = x - 1
            val yIndex = y - 1
            if (op == 1) {
                if (cups(xIndex) != cups(yIndex)) {
                cups = cups.updated(xIndex, !cups(xIndex))
                cups = cups.updated(yIndex, !cups(yIndex))
                }
            } else if (op == 2) {
                val ball = cups(xIndex)
                val (start, end) = cups.splitAt(xIndex)
                val (left, right) = end.tail.splitAt(yIndex - xIndex - 1)
                cups = start ::: (ball :: (left ::: (ball :: right))) ::: end.lastOption.toList
            }
        }

        cups.indexOf(true) + 1
    }

    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val opList = Array.ofDim[(Int, Int, Int)](q)

    for (i <- 0 until q) {
        val Array(op, x, y) = readLine().split(" ").map(_.toInt)
        opList(i) = (op, x, y)
    }

    val result = operationShuffle(opList, n)
    println(result)
}
//解答例使用済み
//断念

/*
import scala.io.StdIn._

object Main extends App {

    val Array(n, q) = readLine().split(" ").map(_.toInt)
    val opList = Array.ofDim[Int](q, 3)
    val start = Array(1) ++ Array.fill(n-1)(0)

    for (i <- 0 until q){
        opList(i) = readLine().split(" ").map(_.toInt)
    }

    def operationShuffle(opList: Array[Array[Int]], board: Array[Int], count: Int, target: Int): Array[Int] = {
        val Array(op, x, y) = opList(count)
        val newBoard = op match {
            case 1 =>{
                board.zipWithIndex.map {
                    case (value, i) => {
                        if (i == x - 1) board(y - 1)
                        else if (i == y - 1) board(x - 1)
                        else value
                    }
                }
            }
            case 2 =>{
                val (left, right) = board.splitAt(x)
                left ++ Array(0) ++ right
            }
        }
        if (count+1 < target){
            operationShuffle(opList, newBoard, count+1, target)
        }else{
            return newBoard
        } 
    }

    val result = operationShuffle(opList, start, 0, q)
    println(result.indexOf(1)+1)
}
*/