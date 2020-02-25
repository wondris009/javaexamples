package cz.speedygonzales.calculator

import spock.lang.Specification

class CalculatorSpec extends Specification {

    def 'should calculate numbers from input file'() {

        given:
        def path = new File(getClass().getResource('/calculator-input.txt').toURI()).absolutePath

        when:
        CalculatorDemo calculatorDemo = new CalculatorDemo()
        def sum = calculatorDemo.calculate(path)

        then:
        sum == 18




    }


}
