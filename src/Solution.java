public class Solution {
    public static void main(String[] args) {

        String a = "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
        String b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";

        System.out.println(addBinary(a, b));

    }

    public static String addBinary(String a, String b) {
        char[] aChars = a.toCharArray();
        char[] bChars = b.toCharArray();

        int decimalA = 0;
        int countA = 0;
        for (int i = a.length() - 1; i > -1; i--) {
            decimalA += ((int) Math.pow(2, countA)) * Character.getNumericValue(aChars[i]);
            countA++;
        }

        int decimalB = 0;
        int countB = 0;
        for (int i = b.length() - 1; i > -1; i--) {
            decimalB += ((int) Math.pow(2, countB)) * Character.getNumericValue(bChars[i]);
            countB++;
        }

        int sum = decimalA + decimalB;

        return Integer.toBinaryString(sum);

    }
}
