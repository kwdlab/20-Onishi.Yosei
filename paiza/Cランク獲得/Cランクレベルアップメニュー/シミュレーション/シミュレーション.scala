import scala.io.StdIn._

object Main extends App {

    val h = readLine.toInt
    val paiza = Array[Int](0)
    val monster = Array[Int](0)

    def paizaAttack(x: Int, paiza: Array[Int], monster: Array[Int]): Array[Int] = {
        if (x == 1 || x == 2){
            paiza ++ Array(1)
        } else {
            paiza ++ Array(monster(x-1) + monster(x-2))
        }
    }
    def monsterAttack(x: Int, paiza: Array[Int], monster: Array[Int]): Array[Int] = {
        if (x == 1 || x == 2){
            monster ++ Array(1)
        } else {
            monster ++ Array(paiza(x-1)*2 + paiza(x-2))
        }
    }
    def loop(count: Int, hp: Int, paiza: Array[Int], monster: Array[Int]): Int = {
        if (hp <= 0){
            return count
        } else {
            val newPaiza = paizaAttack(count+1, paiza, monster)
            val newMonster = monsterAttack(count+1, paiza, monster)
            val newHP = hp - newMonster(count+1)
            loop(count+1, newHP, newPaiza, newMonster)
        }
    }

    println(loop(0, h, paiza, monster))
}