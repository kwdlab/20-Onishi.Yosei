package money

abstract class Money {
    
    protected val amount: Int

    def times(multiplier: Int): Money
    def currency(): String

    def equals(money: Money): Boolean = {
        amount == money.amount && getClass.equals(money.getClass)
    }
}

object Money {
    def dollar(amount: Int): Money = new Dollar(amount)
    def franc(amount: Int): Money = new Franc(amount)
}
