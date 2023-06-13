import scala.io.StdIn._

object Main extends App {

    val n = readLine().toInt
    val An = readLine().split(" ").map(_.toInt)
    var count = 0

    def quickSort(A: Array[Int], left: Int, right: Int): Array[Int] = {
        def swap(i: Int, j: Int) = {
            val tmp = A(i)
            A(i) = A(j)
            A(j) = tmp
        }

        if (left+1 >= right){
            return A
        }
        
        val pivot = A(right-1)
        var cursol = left
        for (i <- left until right-1){
            if(A(i) < pivot){
                swap(cursol, i)
                cursol = cursol + 1
                count = count + 1
            }
        }

        swap(cursol, right-1)
        val newA = quickSort(A, left, cursol)
        val newnewA = quickSort(newA, cursol+1, right)
        return newnewA
    }

    val result = quickSort(An, 0, n)
    println(result.mkString(" "))
    println(count)
}
