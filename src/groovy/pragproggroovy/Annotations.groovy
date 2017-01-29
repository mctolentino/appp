package pragproggroovy

import groovy.transform.Immutable

@Immutable
class CreditCardImmutable {
    String cardNumber
    int creditLimit
}


println new CreditCardImmutable( "4000-1111-2222-3333" , 1000)