package bank
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString

@EqualsAndHashCode
@ToString
class Transaction {
    BigDecimal amount
    String type
}
