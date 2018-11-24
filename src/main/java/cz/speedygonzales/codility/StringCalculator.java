package cz.speedygonzales.codility;

import java.util.ArrayList;
import java.util.List;

/**
 * See test for this class.
 *
 * @author vondracek
 * @since 20.4.15 17:36
 */
public class StringCalculator {

    private List<Integer> stack = new ArrayList<Integer>(0);
    private List<OPERATORS> operatorsStack = new ArrayList<OPERATORS>(0);

    public int calculate(String input) {

        //wrong value
        int result = -1;

        if (input != null) {

            if (input.length() < 3) {
                return -1;
            }

            String[] stringStack = new String[input.length()];

            for (int i = 0; i < input.length(); i++) {
                stringStack[i] = String.valueOf(input.charAt(i));
            }


            for (String s : stringStack) {

                if (isNumeric(s)) {

                    stack.add(Integer.valueOf(s));

                } else {

                    if (stack.size() < 2) {
                        return -1;
                    }

                    operatorsStack.add(getOperator(s));

                    updateStack(getFirstOperator());
                }
            }
            result = doFinalCounting();
        }


        return result;
    }

    private int doFinalCounting() {

        if (operatorsStack.size() > 2) {
            return -1;
        }

        if (stack.size() == 1) {
            return stack.get(0);
        }

        return 0;
    }

    private void updateStack(OPERATORS lastOperator) {

        Integer operand1 = stack.get(0);
        Integer operand2 = stack.get(1);

        stack.remove(0);
        stack.remove(0);

        int sum = 0;

        if (lastOperator == OPERATORS.MULTIPLE) {
            sum = operand1 * operand2;
        } else if (lastOperator == OPERATORS.ADD) {
            sum = operand1 + operand2;
        }

        stack.add(sum);
    }

    private OPERATORS getFirstOperator() {

        OPERATORS result = null;
        if (operatorsStack != null && !operatorsStack.isEmpty()) {
            result = operatorsStack.get(0);
        }

        operatorsStack.remove(0);

        return result;
    }

    public boolean isNumeric(String maybeNumeric) {

        return maybeNumeric != null && maybeNumeric.matches("[0-9]+");
    }

    private OPERATORS getOperator(String operator) {

        OPERATORS result = OPERATORS.MULTIPLE;

        if (operator.equals("+")) {
            result = OPERATORS.ADD;
        }

        return result;
    }

    private enum OPERATORS {
        ADD, MULTIPLE
    }
}
