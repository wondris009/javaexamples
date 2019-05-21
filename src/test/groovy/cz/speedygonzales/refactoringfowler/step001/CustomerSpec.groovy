package cz.speedygonzales.refactoringfowler.step001

import spock.lang.Specification

import static cz.speedygonzales.refactoringfowler.step001.Movie.*

class CustomerSpec extends Specification {


    def 'should produce correct rental string for few customers'() {

        given:
        def customer1 = new Customer('Peter')
        customer1.addRental(new Rental(new Movie('Batman', REGULAR), 10))
        customer1.addRental(new Rental(new Movie('Locika', CHILDRENS), 30))

        def customer2 = new Customer('Rene')
        customer2.addRental(new Rental(new Movie('Superman', REGULAR), 10))
        customer2.addRental(new Rental(new Movie('Shawshank', REGULAR), 50))
        customer2.addRental(new Rental(new Movie('Sherlock', REGULAR), 100))

        def customer3 = new Customer('Luky')
        customer3.addRental(new Rental(new Movie('Film1', REGULAR), 7))
        customer3.addRental(new Rental(new Movie('Film2', NEW_RELEASE), 13))
        customer3.addRental(new Rental(new Movie('Film3', CHILDRENS), 25))

        when:
        def statement1 = customer1.statement()
        def statement2 = customer2.statement()
        def statement3 = customer3.statement()

        then:
        statement1 == 'Rental Record for Peter\n\tBatman\t14.0\n\tLocika\t42.0\nAmount owed is 56.0\nYou earned 2 frequent renter points'
        statement2 == 'Rental Record for Rene\n\tSuperman\t14.0\n\tShawshank\t74.0\n\tSherlock\t149.0\nAmount owed is 237.0\nYou earned 3 frequent renter points'
        statement3 == 'Rental Record for Luky\n\tFilm1\t9.5\n\tFilm2\t39.0\n\tFilm3\t34.5\nAmount owed is 83.0\nYou earned 4 frequent renter points'
    }
}
