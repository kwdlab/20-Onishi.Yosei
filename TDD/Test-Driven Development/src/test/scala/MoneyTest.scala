package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    val five = new Dollar(5)
    var product = five.times(2)
    assert(product.amount == 10)
    product = five.times(3)
    assert(product.amount == 15)
}