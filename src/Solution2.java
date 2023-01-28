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


        //When a.length() > b.length()
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

        //When b.length() > a.length()
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

        //When a == b
        if (a.length() == b.length()) {
            for (char c : aChar) {
                aStack.push(c);
            }

            for (char c : bChar) {
                bStack.push(c);
            }
        }

        boolean isOne = false;

        //Add Binary
        while (!aStack.isEmpty()) {
            char aValue = aStack.pop();
            char bValue = bStack.pop();

            switch (aValue) {
                case '0':
                    if (!isOne && bValue == '0') {
                        aPlusBStack.push('0');
                        break;
                    } else if (!isOne && bValue == '1') {
                        aPlusBStack.push('1');
                        break;
                    } else if (isOne && bValue == '0') {
                        aPlusBStack.push('1');
                        isOne = false;
                        break;
                    } else if (isOne && bValue == '1') {
                        aPlusBStack.push('0');
                        break;
                    }
                case '1':
                    if (!isOne && bValue == '1') {
                        aPlusBStack.push('0');
                        isOne = true;
                        break;
                    } else if (!isOne && bValue == '0') {
                        aPlusBStack.push('1');
                        break;
                    } else if (isOne && bValue == '1') {
                        aPlusBStack.push('1');
                        isOne = true;
                        break;
                    } else if (isOne && bValue == '0') {
                        aPlusBStack.push('0');
                        isOne = true;
                        break;
                    }
            }

        }

        if (isOne) {
            aPlusBStack.push('1');
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
