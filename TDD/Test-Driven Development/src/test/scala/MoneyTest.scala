package money

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.Assertions._

class MoneyTest extends AnyFlatSpec {
    val five = new Dollar(5)
    five.times(2)
    assert(five.amount == 10)
}