package cz.speedygonzales.designpatterns.strategypattern;

/**
 * @author vondracek
 * @since 17.1.2017 22:40
 */
public class StrategyDemo {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println(context.executeStrategy(5, 10));

        context = new Context(new OperationMultiply());
        System.out.println(context.executeStrategy(5, 10));

        context = new Context(new OperationSubstract());
        System.out.println(context.executeStrategy(5, 10));

    }

}
