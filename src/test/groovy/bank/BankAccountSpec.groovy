package bank

import spock.lang.Specification

class BankAccountSpec extends Specification {
    def "bank account starting balance should be 0"() {
        given:
        BankAccount bankAccount = new BankAccount()

        when:
        BigDecimal startingBalance = bankAccount.balance

        then:
        assert startingBalance == 0
    }
}
