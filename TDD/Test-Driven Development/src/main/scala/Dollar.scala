package money

class Dollar (private val amount: Int) {
    
    def times(multiplier: Int): Dollar = {
        new Dollar(amount * multiplier)
    }

    def equals(dollar: Dollar): Boolean = {
        amount == dollar.amount
    }
}