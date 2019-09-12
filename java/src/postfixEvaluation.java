import java.util.Stack;

public class postfixEvaluation {
    int result (int od1, char op, int od2) {
        switch (op) {
            case '^' : return (od2 ^ od1);

            case '/' : return (od2 / od1);

            case '*' : return (od2 * od1);

            case '+' : return (od2 + od1);

            case '-' : return (od2 - od1);
        }
        return 0;
    }

    int postfixEvaluation (char[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<arr.length; i++) {
            if (arr[i] >= 0 && arr[i] <= 9)
                stack.push(arr[i] - '0');
            else {
                int res = result (stack.pop(), arr[i], stack.pop());
                stack.push(res);
            }
        }
        return 0;
    }
    public static void main (String[] args) {
        String string = "231*+9-";
        char[] arr = string.toCharArray();
        postfixEvaluation pe = new postfixEvaluation();
        System.out.println(pe.postfixEvaluation(arr));
    }
}
