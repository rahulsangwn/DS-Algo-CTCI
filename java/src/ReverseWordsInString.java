// Source: https://www.geeksforgeeks.org/reverse-words-in-a-given-string/
// Time Complexity: O(n)

public class ReverseWordsInString {
    public static void main(String args[]) {
        String string = "i.like.this.program.very.much";
        char[] str = string.toCharArray(), res;
        res = new char[str.length];

        reverse(str, res);

        System.out.println(res);
    }

    private static void reverse(char[] str, char[] res) {
        int prevI = str.length-1, start = 0, i;
        for(i = str.length-1; i >= 0; i--) {
            if(str[i] == '.') {
                System.arraycopy(str, i+1, res, start, prevI-i);
                start += prevI -i + 1;
                prevI = i - 1;
                res[start-1] = '.';
            }
        }
        System.arraycopy(str, 0, res, start, prevI-i);
    }
}
