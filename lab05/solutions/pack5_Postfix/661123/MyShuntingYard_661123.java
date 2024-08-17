package solutions.pack5_Postfix;

import java.util.StringTokenizer;

public class MyShuntingYard {

    private static int order(String c) {
        switch (c) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                return 0;
        }
    }

    public static String infixToPostfix(String infixString) {
        MyQueueListWrap<String> queue = new MyQueueListWrap<>();
        MyStackL stack = new MyStackL();
        String resultPostfixString = "";
        StringTokenizer st = new StringTokenizer(infixString);

        while (st.hasMoreTokens()) {
            String t = st.nextToken();
            if (MyRPN.isNumeric(t)) {
                queue.enqueue(t);
            } else if (t.equals("(")) {
                stack.push(t);
            } else if (t.equals(")")) {
                while (!stack.isEmpty() && !stack.peek().equals("(")) {
                    queue.enqueue(stack.pop());
                }
                stack.pop(); // discard "("
            } else {
                while (!stack.isEmpty() && order(stack.peek()) >= order(t)) {
                    queue.enqueue(stack.pop());
                }
                stack.push(t);
            }
            System.out.println("current q = " + queue.dumpToString());
        }

        while (!stack.isEmpty()) {
            queue.enqueue(stack.pop());
        }

        resultPostfixString = queue.dumpToString();
        return resultPostfixString; // "happy coding";
    }

    public static void main(String[] args) {
        String infixExpression = "( 4 + 2 ) / 3 * ( 8 - 5 )";
        String postfixExpression = infixToPostfix(infixExpression);
        System.out.println("Postfix Expression: " + postfixExpression);
    }
}

