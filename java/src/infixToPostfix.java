import java.util.Stack;

public class infixToPostfix {

    int perc (char operator) {
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

        infixToPostfix fn = new infixToPostfix();

        Stack<Character> stack = new Stack<Character>();

        for (int i=0; arr[i] != '\0'; i++) {
            if (arr[i] >= 'a' && arr[i] <= 'z') {
                System.out.print(arr[i]);
            } else if (arr[i] != ')'){
                if (fn.perc(arr[i]) > fn.perc(stack.peek()) || stack.peek() == '(') {
                    stack.push(arr[i]);
                } else {
                    while (fn.perc(stack.peek()) >= arr[i] && arr[i] != '(') {
                        System.out.print(stack.pop());
                    }
                }
            } else if (arr[i] == ')') {
                while (arr[i] != '(') {
                    System.out.print(stack.pop());
                }
                stack.pop();
            }
        }

        while(!stack.empty())
            System.out.print(stack.pop());
    }
}
