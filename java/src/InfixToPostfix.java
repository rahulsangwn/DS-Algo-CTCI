import java.util.EmptyStackException;
import java.util.Locale;
import java.util.Stack;

public class InfixToPostfix {

    private static int perc (char operator) {
        if (operator == '^')
            return 3;
        else if (operator == '*' || operator == '/')
            return 2;
        else if (operator == '+' || operator == '-')
            return 1;
        else
            return 0;
    }
    public static void main (String[] args) {
        String string = "a+b*(c^d-e)^(f+g*h)-i";
        char[] arr = string.toCharArray();
        System.out.println(arr);

        Stack<Character> stack = new Stack<>();

        for (char c : arr) {
            char s;
            if (Character.isLetter(c)) {
                System.out.print(c);
            } else if (c != ')') {
                if (!stack.empty()) s = stack.peek();
                else {
                    s = '%';  // For getting 0 precedence
                }

                if (perc(c) > perc(s) ||  c == '(') {
                    stack.push(c);
                } else {
                    while (!stack.empty() && perc(s) >= perc(c) && stack.peek() != '(') {
                        System.out.print(stack.pop());
                    }
                    stack.push(c);
               }
            } else {

                while (!stack.empty() && stack.peek() != '(') {
                    System.out.print(stack.pop());
                }

                if (!stack.empty()) stack.pop();

            }
        }

        while(!stack.empty())
            System.out.print(stack.pop());
    }
}
