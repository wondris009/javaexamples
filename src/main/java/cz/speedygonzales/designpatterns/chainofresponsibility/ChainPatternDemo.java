package cz.speedygonzales.designpatterns.chainofresponsibility;

/**
 * Use When:
 * - Multiple objects may handle a request and the handler doesn't have to be a specific object.
 * - A set of objects should be able to handle a request with the handler determined at runtime.
 * - A request not being handled is an acceptable potential outcome.
 */
public class ChainPatternDemo {

    public static void main(String[] args) {

        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");

        loggerChain.logMessage(AbstractLogger.DEBUG, "This is an debug level information.");

        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.");
    }

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }
}
