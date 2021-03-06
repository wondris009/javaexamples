package cz.speedygonzales.designpatterns.strategy;

/**
 * @author vondracek
 * @since 17.1.2017 22:38
 */
public class OperationAdd implements Strategy {

    @Override
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}
