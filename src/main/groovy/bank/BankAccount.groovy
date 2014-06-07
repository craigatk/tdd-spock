package bank

class BankAccount {
    BigDecimal balance = 0

    void deposit(BigDecimal amount) {
        balance += amount
    }
}
