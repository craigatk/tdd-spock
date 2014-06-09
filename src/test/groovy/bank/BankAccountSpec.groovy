package bank

import spock.lang.Specification
import spock.lang.Unroll

class BankAccountSpec extends Specification {
    def "bank account starting balance should be 0"() {
        given:
        BankAccount bankAccount = new BankAccount()

        when:
        BigDecimal startingBalance = bankAccount.balance

        then:
        assert startingBalance == 0
    }

    @Unroll
    def 'depositing #amount should increase balance to #expectedBalance'() {
        given:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.deposit(amount)

        then:
        assert bankAccount.balance == expectedBalance

        where:
        amount || expectedBalance
        10     || 10
        20     || 20
    }

    @Unroll
    def "withdrawing #amount should reduce balance to #expectedBalance"() {
        given:
        BankAccount bankAccount = new BankAccount()

        bankAccount.deposit(20)

        when:
        bankAccount.withdraw(amount)

        then:
        assert bankAccount.balance == expectedBalance

        where:
        amount || expectedBalance
        5      || 15
        10     || 10
        15     || 5
    }

    def "withdrawing and depositing should update balance and create transaction list"() {
        given:
        BankAccount bankAccount = new BankAccount()

        when:
        bankAccount.deposit(50)
        bankAccount.withdraw(20)
        bankAccount.deposit(10)

        then:
        assert bankAccount.balance == 40

        and:
        assert bankAccount.transactions.contains(new Transaction(amount: 50, type: 'd'))
        assert bankAccount.transactions.contains(new Transaction(amount: 20, type: 'w'))
        assert bankAccount.transactions.contains(new Transaction(amount: 10, type: 'd'))
    }
}
