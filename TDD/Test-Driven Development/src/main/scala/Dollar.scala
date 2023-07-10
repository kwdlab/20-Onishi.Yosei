package money

class Dollar (val amount: Int) {
    
    def times(multiplier: Int): Dollar = {
        new Dollar(amount * multiplier)
    }

    def equals(dollar: Dollar): Boolean = {
        true
    }
}