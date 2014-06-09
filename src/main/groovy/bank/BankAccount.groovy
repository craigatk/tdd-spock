package bank

class BankAccount {
    List<Transaction> transactions = []

    void deposit(BigDecimal amount) {
        transactions << new Transaction(type: 'd', amount: amount)
    }

    void withdraw(BigDecimal amount) {
        transactions << new Transaction(type: 'w', amount: amount)
    }

    BigDecimal getBalance() {
        if (transactions) {
            return transactions.sum { transaction ->
                if (transaction.type == 'd') {
                    transaction.amount
                } else {
                    -transaction.amount
                }
            }
        } else {
            return 0
        }
    }
}
