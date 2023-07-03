import scala.io.StdIn._

object Main extends App {

    @scala.annotation.tailrec
    def lowerBound(exit: (Int, Int) => Boolean)(an: Array[Int], left: Int, right: Int, target: Int): Int = {
        if (exit(left, right)) left
        else {
            val mid = left + (right - left) / 2
            if (an(mid) < target) lowerBound(exit)(an, mid + 1, right, target) 
            else lowerBound(exit)(an, left, mid, target)
        }
    }
    @scala.annotation.tailrec
    def upperBound(exit: (Int, Int) => Boolean)(an: Array[Int], left: Int, right: Int, target: Int): Int = {
        if (exit(left, right)) left
        else {
            val mid = left + (right - left) / 2
            if (an(mid) <= target) upperBound(exit)(an, mid + 1, right, target) 
            else upperBound(exit)(an, left, mid, target)
        }
    }

    val n = readLine().toInt
    val al = Array.fill[Array[Int]](n)(readLine().trim.split(" ").map(_.toInt))
    val aSorted = al.map(_(0)).sorted
    val lSorted = al.map(_(1)).sorted

    for (i <- al) {
        val before = lowerBound((l: Int, r: Int) => l >= r)(lSorted, 0, lSorted.length, i(0))
        val after = n - upperBound((l: Int, r: Int) => l >= r)(aSorted, 0, aSorted.length, i(1))
        println(n - 1 - (before + after))
    }
}
//解答例使用済み
//下の分割は失敗

/*
import scala.io.StdIn._

object Main extends App {

    @scala.annotation.tailrec
    def upperLower(exit: (Int, Int) => Boolean)(sel: (Int, Int) => Boolean)(an: Array[Int], left: Int, right: Int, target: Int): Int = {
        if (exit(left, right)) left
        else {
            val mid = left + (right - left) / 2
            if (sel(an(mid), target)) upperLower(exit)(sel)(an, mid + 1, right, target) 
            else upperLower(exit)(sel)(an, left, mid, target)
        }
    }

    val n = readLine().toInt
    val al = Array.fill[Array[Int]](n)(readLine().trim.split(" ").map(_.toInt))
    val aSorted = al.map(_(0)).sorted
    val lSorted = al.map(_(1)).sorted

    for (i <- al) {
        val before = upperLower((l: Int, r: Int) => l >= r)((m: Int, t: Int) => m <= t)(lSorted, 0, lSorted.length, i(0))
        val after = n - upperLower((l: Int, r: Int) => l >= r)((m: Int, t: Int) => m < t)(aSorted, 0, aSorted.length, i(1))
        println(n - 1 - (before + after))
    }
}
*/