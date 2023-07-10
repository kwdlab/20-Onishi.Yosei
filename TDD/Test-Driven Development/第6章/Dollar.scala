package money

class Dollar(amount: Int) extends Money(amount) {
    
    def times(multiplier: Int): Dollar = {
        new Dollar(amount * multiplier)
    }
}