import scala.io.StdIn._

object Main extends App {

    class basic(val amount: Int, val past: String, val leaving: Int){

        def check(menu: String, price: Int) : Int = {
            if (menu == "alcohol" || menu == "0"){
                0
            } else {
                price
            }
        }
        def orderPass(menu: String, price: Int): basic = {
            menu match {
                case "A" => 
                    println(amount)
                    new basic(amount, past, 1)
                case _ =>
                    new basic(amount + check(menu, price), "", leaving)
            }
        }
        def printOut() = {
            println(amount)
        }
    }
    class plus(override val amount: Int, override val past: String, override val leaving: Int) extends basic(amount, past, leaving) {

        def discount(menu: String, price: Int) : (Int, String) = {
            val latest = past + menu
            if ((past.contains("alcohol") || past.contains("0")) && menu == "food"){
                (price - 200, latest)
            } else if (menu == "0") {
                (500, latest)
            } else {
                (price, latest)
            }
        }
        override def orderPass(menu: String, price: Int): plus = {
            menu match {
                case "A" => 
                    println(amount)
                    new plus(amount, past, 1)
                case _ =>
                    val (p, latest) = discount(menu, price)
                    new plus(amount + p, latest, leaving)
            }
        }
    }

    val Array(n, k) = readLine().split(" ").map(_.toInt)
    val customersList: Array[basic] = (0 until n).foldLeft(Array.empty[basic]) { (customers, _) =>
        val age = readLine().toInt
        val customer = {
            if (age >= 20 ){
                new plus(0, "", 0)
            } else {
                new basic(0, "", 0)
            }
        }
        customers :+ customer
    }    

    for(i <- 0 until k){
        val line = readLine().split(" ")
        val index = line(0).toInt - 1
        val readMenu = line(1)
        val readPrice = {
            if (line.length == 3){
                line(2).toInt
            } else {
                0
            }
        }
        customersList(index) = customersList(index).orderPass(readMenu, readPrice) 
    }
    println(customersList.count(_.leaving == 1))
}
