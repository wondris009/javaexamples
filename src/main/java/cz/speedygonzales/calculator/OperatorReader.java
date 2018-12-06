package cz.speedygonzales.calculator;

import java.util.ArrayList;
import java.util.List;

public class OperatorReader {

    private List<String> data;

    public OperatorReader(List<String> data) {
        this.data = data;
    }

    public List<Operator> extractOperators() throws OperatorException {

        List<Operator> result = new ArrayList<>();

        for (String instruction : data) {
            double operand = getOperand(instruction);
            Operation operation = getOperation(instruction);

            result.add(new Operator(operand, operation));
        }

        if(result.isEmpty()) {
            throw new OperatorException("There are no operations.");
        }

        return result;
    }

    public double getOperand(String line) throws OperatorException {

        for (int i = 0; i < line.length(); i++) {
            char c = line.charAt(i);

            if (Character.isDigit(c)) {
                return Double.valueOf(line.substring(i).trim());
            }
        }

        throw new OperatorException("Can't locate operand in instruction " + line);
    }

    private Operation getOperation(String line) {

        String operationName = line.split(" ")[0].trim();

        Operation operation = null;

        switch (operationName) {
            case "ADD":
                operation = new OperationAdd();
                break;
            case "SUB":
                operation = new OperationSubstract();
                break;
            case "MUL":
                operation = new OperationMultiply();
                break;
            case "DIV":
                operation = new OperationDivide();
                break;
        }

        if (operation == null) {
            throw new IllegalStateException("Unable to identify operation by name " + operationName);
        }

        return operation;
    }
}
