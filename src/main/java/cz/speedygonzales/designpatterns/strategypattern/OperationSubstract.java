package cz.speedygonzales.designpatterns.strategypattern;

/**
 * @author vondracek
 * @since 17.1.2017 22:38
 */
public class OperationSubstract implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
