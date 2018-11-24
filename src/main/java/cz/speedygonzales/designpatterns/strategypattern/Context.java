package cz.speedygonzales.designpatterns.strategypattern;

/**
 * @author vondracek
 * @since 17.1.2017 22:39
 */
public class Context {

    private Strategy strategy;

    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    public int executeStrategy(int n1, int n2) {
        return strategy.doOperation(n1, n2);
    }
}
