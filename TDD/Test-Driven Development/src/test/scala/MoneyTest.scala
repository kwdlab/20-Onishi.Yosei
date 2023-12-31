package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    "testMultiplication" should "1" in {
        val five = Money.dollar(5)
        assert(five.times(2).equals(Money.dollar(10)) == true)
        assert(five.times(3).equals(Money.dollar(15)) == true)
    }

    "testEquality" should "2" in {
        assert(Money.dollar(5).equals(Money.dollar(5)) == true)
        assert(Money.dollar(5).equals(Money.dollar(6)) == false)
        assert(Money.dollar(5).equals(Money.franc(5)) == false)  
    }

    "testCurrency" should "4" in {
        assert(Money.dollar(1).currency() == "USD")
        assert(Money.franc(1).currency() == "CHF")
    }
}