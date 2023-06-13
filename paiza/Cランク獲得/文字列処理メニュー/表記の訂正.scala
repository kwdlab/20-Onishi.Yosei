import scala.io.StdIn._

object Main extends App {

    val S = readLine()
    var Sch : Array[Char] = Array.empty
    var result : Array[Char] = Array.empty
    var top : Array[Char] = Array.empty
    var bottom : Array[Char] = Array.empty

    if (S.contains(".")){
        for (i <-0 until  S.length){
            if (i == S.indexOf(".") || S(i) != '.'){
                Sch = Sch ++ Array(S(i))
            }
        }
        var flag = 0
        for (i <- Sch){
            if (i != '0' && flag == 0){
                flag = 1
                top = top ++ Array(i)
            } else if (flag == 1){
                top = top ++ Array(i)
            }
        }
        if (top(0) == '.'){
            top = Array('0') ++ top.drop(0)
        }
        
        flag = 0
        for (i <- top.reverse){
            if (i != '0' && flag == 0){
                flag = 1
                bottom = bottom ++ Array(i)
            } else if (flag == 1){
                bottom = bottom ++ Array(i)
            }
        }
        val rFloat = bottom.reverse.mkString("")
        println(rFloat)

    } else {
        var flag = 0
        for (i <- S){
            if (i != '0' && flag == 0){
                flag = 1
                result = result ++ Array(i)
            } else if (flag == 1){
                result = result ++ Array(i)
            }
       }
        val rInt = result.mkString("")
        println(rInt)    
    }
}