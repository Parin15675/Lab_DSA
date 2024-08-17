package solutions.pack5_Postfix;

import java.util.Stack;
import java.util.regex.Pattern;

public class MyRPN {

    private static Pattern pattern = Pattern.compile("-?\\d+(\\.\\d+)?");

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        return pattern.matcher(strNum).matches();
    }

    public static double computeRPN(String rpn) {
        Stack<Double> stack = new Stack<>();
        String[] tokens = rpn.split("\\s+");

        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];

            if (isNumeric(token)) {
                stack.push(Double.parseDouble(token));
            } else {
                double b = stack.pop();
                double a = stack.pop();

                if (token.equals("*")) {
                    stack.push(a * b);
                } else if (token.equals("/")) {
                    stack.push(a / b);
                } else if (token.equals("+")) {
                    stack.push(a + b);
                } else if (token.equals("-")) {
                    stack.push(a - b);

                }
            }

            
        }
        return stack.pop();
    }
}
