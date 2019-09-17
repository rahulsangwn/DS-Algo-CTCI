import java.util.Stack;

public class PostfixEvaluation {
    private int result (int od1, char op, int od2) {

        switch (op) {
            case '^' : return (od2 ^ od1);

            case '/' : return (od2 / od1);

            case '*' : return (od2 * od1);

            case '+' : return (od2 + od1);

            case '-' : return (od2 - od1);
        }
        return 0;
    }

    private int postfixEvaluation(char[] arr) {
        Stack<Integer> stack = new Stack<>();

        for (char c : arr) {
            if (Character.isDigit(c))
                stack.push(c - '0');
            else {
                int od1 = -1, od2 = -1;

                if (!stack.empty()) od1 = stack.pop();
                if (!stack.empty()) od2 = stack.pop();
                else {
                    System.out.println("Postfix equation incompatible");
                    return -1;
                }

                int res = result(od1, c, od2);
                stack.push(res);
            }
        }
        return stack.pop();
    }
    public static void main (String[] args) {
        String string = "231*+9-";
        char[] arr = string.toCharArray();
        PostfixEvaluation pe = new PostfixEvaluation();
        System.out.println(pe.postfixEvaluation(arr));
    }
}
