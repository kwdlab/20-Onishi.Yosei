import scala.io.StdIn._

object Main extends App {

    class Employee(val number: Int, val name: String){
        def getNum() : Int = {
            number
        }
        def getName() : String = {
            name
        }
        def changeNum(cNum: Int): Employee = {
            new Employee(cNum, name)
        }        
        def changeName(cName: String): Employee = {
            new Employee(number, cName)
        }
    }

    val n = readLine().toInt
    val employeesList: Array[Employee] = (0 until n).foldLeft(Array.empty[Employee]) { (employees, _) =>
        val line = readLine().split(" ")
        line(0) match {
            case "make" =>
                val newEmployee = new Employee(line(1).toInt, line(2))
                employees :+ newEmployee
            case "getnum" =>
                println(employees(line(1).toInt-1).getNum())
                employees
            case "getname" =>
                println(employees(line(1).toInt-1).getName())
                employees
            case "change_num" =>
                val tmp = employees(line(1).toInt-1).changeNum(line(2).toInt)
                employees(line(1).toInt-1) = tmp
                employees
            case "change_name" =>
                val tmp = employees(line(1).toInt-1).changeName(line(2))
                employees(line(1).toInt-1) = tmp
                employees
            case _ => 
                employees
        }
    }
}