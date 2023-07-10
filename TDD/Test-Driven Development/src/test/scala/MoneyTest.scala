package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    "testMultiplication" should "testMultiplication" in {
        val five = new Dollar(5)
        assert(five.times(2) == new Dollar(10))
        assert(five.times(3) == new Dollar(15)) 
    }

    "testEquality" should "testEquality" in {
        assert(new Dollar(5).equals(new Dollar(5)) == true)
        assert(new Dollar(5).equals(new Dollar(6)) == false)  
    }
}