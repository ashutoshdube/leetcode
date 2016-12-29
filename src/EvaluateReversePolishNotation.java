import java.util.HashSet;
import java.util.Stack;

/**
 * Created by Ashutosh on 12/27/16.
 */
public class EvaluateReversePolishNotation {

    public int evalRPN(String[] tokens) {

        Stack<String> numbers = new Stack<>();
        HashSet<String> operator = new HashSet<>();
        operator.add("+");
        operator.add("*");
        operator.add("/");
        operator.add("-");

        int number1, number2;
        for(int i = 0; i < tokens.length; i++) {

            if(operator.contains(tokens[i])) {

                number2 = Integer.valueOf(numbers.pop());
                number1 = Integer.valueOf(numbers.pop());
                numbers.push(Integer.toString(eval(number1, number2, tokens[i])));

            } else {
                numbers.push(tokens[i]);
            }

        }

        if(numbers.size() == 1)
            return Integer.valueOf(numbers.pop());
        else
            return -1;
    }

    int eval(int number1, int number2, String operator) {

        if(operator.equals("+")) {
            return number1 + number2;
        } else if(operator.equals("*")) {
            return number1 * number2;
        } else if(operator.equals("-")) {
            return number1 - number2;
        } else if(operator.equals("/")) {
            return number1 / number2;
        }

        return -1;
    }

    public static void main(String[] args) {

    }


}
