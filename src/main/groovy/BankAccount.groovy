class BankAccount {
    BigDecimal balance = 0

    void deposit(BigDecimal amount) {
        balance += amount
    }

    void withdraw(BigDecimal amount) {
        balance -= amount
    }
}
