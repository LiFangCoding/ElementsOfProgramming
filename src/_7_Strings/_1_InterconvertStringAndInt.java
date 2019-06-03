package _7_Strings;

/**
 * A string is a sequence of characters.
 * <p>
 * In this problem, you are to implement methods that take a string representing an integer and return the corresponding integer, and vice versa. Your code should handle negative integers. You cannot use library functions like stoi in C++ and parselnt in Java.
 * Implement string/integer inter-conversion functions.
 */
public class _1_InterconvertStringAndInt {
    // Hint: Build the result one digit at a time.
    // Consider overflow. Negative is ok.
    public static String intToString(int x) {
        boolean isNegative = false;

        if (x < 0) {
            isNegative = true;
        }

        StringBuilder sb = new StringBuilder();
        do {
            // important. else it will be 55.
            sb.append((char) ('0' + Math.abs(x % 10)));
            x /= 10;
        } while (x != 0);

        if (isNegative) {
            // Adds the negative sign back
            sb.append('-');
        }
        sb.reverse();
        return sb.toString();
    }

    public static int stringToInt(String s) {
        int res = 0;
        boolean isNeg = false;
        int i = 0;

        if (s.charAt(i) == '-') {
            i = 1;
            isNeg = true;
        }


        while (i < s.length()) {
            int digit = s.charAt(i++) - '0';
            if (isNeg) {
                digit = digit * -1;
            }
            // Here is minus digit. Important. For positive is +, for negative is -.
            res = res * 10 + digit;
        }

        return res;
    }
}
