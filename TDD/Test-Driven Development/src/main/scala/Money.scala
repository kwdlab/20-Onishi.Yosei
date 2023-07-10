package money

class Money(protected val amount: Int) {

    def equals(money: Money): Boolean = {
        amount == money.amount && getClass().equals(money.getClass())
    }

    def dollar: Dollar = {
        new Dollar(amount)
    }
}