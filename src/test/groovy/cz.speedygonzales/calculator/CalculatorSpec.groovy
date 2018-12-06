package cz.speedygonzales.calculator

import spock.lang.Specification

class CalculatorSpec extends Specification {

    def 'should calculate numbers from input file'() {

        given:
        def path = 'src/cz/speedygonzales/calculator/calculator-input.txt'

        when:
        CalculatorDemo calculatorDemo = new CalculatorDemo()
        def sum = calculatorDemo.calculate(path)

        then:
        sum == 18




    }


}
