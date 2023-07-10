package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    "testMultiplication" should "1" in {
        val five = new Dollar(5)
        assert(five.times(2).equals(new Dollar(10)) == true)
        assert(five.times(3).equals(new Dollar(15)) == true)
    }

    "testEquality" should "2" in {
        assert(new Dollar(5).equals(new Dollar(5)) == true)
        assert(new Dollar(5).equals(new Dollar(6)) == false)  
    }

    "testFrancMultiplication" should "3" in {
        val five = new Franc(5)
        assert(five.times(2).equals(new Franc(10)) == true)
        assert(five.times(3).equals(new Franc(15)) == true)
    }
}