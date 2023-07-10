package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    "testMultiplication" should "testMultiplication" in {
        val five = new Dollar(5)
        var product = five.times(2)
        assert(product.amount == 10)
        product = five.times(3)
        assert(product.amount == 15)        
    }

    "testEquality" should "testEquality" in {
        assert(new Dollar(5).equals(new Dollar(5)) == true)
        assert(new Dollar(5).equals(new Dollar(6)) == false)  
    }
}