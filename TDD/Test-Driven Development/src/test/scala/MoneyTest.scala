package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    "testMultiplication" should "1" in {
        val five = new Money(5).dollar
        assert(five.times(2).equals(new Money(10).dollar) == true)
        assert(five.times(3).equals(new Money(15).dollar) == true)
    }

    "testEquality" should "2" in {
        assert(new Money(5).dollar.equals(new Money(5).dollar) == true)
        assert(new Money(5).dollar.equals(new Money(6).dollar) == false)
        assert(new Money(5).franc.equals(new Money(5).franc) == true)
        assert(new Money(5).franc.equals(new Money(6).franc) == false)
        assert(new Money(5).dollar.equals(new Money(5).franc) == false)  
    }

    "testFrancMultiplication" should "3" in {
        val five = new Money(5).franc
        assert(five.times(2).equals(new Money(10).franc) == true)
        assert(five.times(3).equals(new Money(15).franc) == true)
    }
}