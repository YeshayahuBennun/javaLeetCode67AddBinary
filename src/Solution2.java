import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {

        String a = "11";
        String b = "11";

        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        Stack<Character> aStack = new Stack<>();
        for (char c : aChar) {
            aStack.push(c);
        }

        Stack<Character> bStack = new Stack<>();
        for (char c : bChar) {
            bStack.push(c);
        }

        int length;
        if (a.length() > b.length()) {
            length = a.length();

            while (length > 0) {
                if (aStack.pop() != null && bStack.pop() != null) {
                    //TODO
                }
                length--;
            }
        } else {
            length = b.length();

            while (length > 0) {
                if (bStack.pop() != null && aStack.pop() != null) {
                    //TODO
                }
                length--;
            }
        }
        return null;
    }
}
