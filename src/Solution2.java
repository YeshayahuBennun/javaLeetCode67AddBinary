import java.util.Arrays;
import java.util.Stack;

public class Solution2 {
    public static void main(String[] args) {

        String a = "11";
        String b = "1";

        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();
        Stack<Character> aStack = new Stack<>();
        Stack<Character> bStack = new Stack<>();

        Stack<Character> aPlusBStack = new Stack<>();
        char prev = '0';

        if (a.length() > b.length()) {
            for (char c : aChar) {
                aStack.push(c);
            }
            //Fill bStack with previous zeros.
            for (int i = 0; i < a.length() - b.length(); i++) {
                bStack.push('0');
            }

            for (char c : bChar) {
                bStack.push(c);
            }
        }

        if (b.length() > a.length()) {
            for (char c : bChar) {
                bStack.push(c);
            }
            //Fill aStack with previous zeros.
            for (int i = 0; i < b.length() - a.length(); i++) {
                aStack.push('0');
            }

            for (char c : aChar) {
                aStack.push(c);
            }
        }

        for (int i = 0; i < aStack.size(); i++) {

            if (prev == '0' && aStack.pop() == '1' && bStack.pop() == '1') {
                aPlusBStack.push('0');
                prev = '1';
            }

            if (prev == '1' && aStack.pop() == '1' && bStack.pop() == '0') {
                aPlusBStack.push('0');
            }

            if (i == aStack.size()) {
                aPlusBStack.push(prev);
            }
        }

        char[] result = new char[aPlusBStack.size()];

        for (int i = 0; i < result.length; i++) {
            result[i] = aPlusBStack.pop();
        }

        char[] newResult = new char[result.length];

        StringBuilder stb = new StringBuilder();

        for (int i = 0; i < newResult.length; i++) {
            stb.append(result[i]);
        }

        return stb.toString();
    }
}
