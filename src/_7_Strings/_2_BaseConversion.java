package _7_Strings;

/**
 * The base b number system generalizes the decimal number system:
 * the string denotes in base-b the integer.
 * <p>
 * Write a program performs base conversion. The input is a string, an integer b1.
 * The ouput should be the string representing the integer in b2.
 * <p>
 * Assume 2 < b\,b2 < 16. Use "A" to represent 10, "B" for 11, ... , and "F" for 15.
 * (For example, if the string is "615", b1 is 7 and b2 is 13,then the result should be"1A7",
 * since 6 x 7^2+ 1x7 + 5 = 1 * 13^ 2 + 10 * 13 + 7.)
 */
public class _2_BaseConversion {
    // Hint: What base can you easily convert to and from?
    // We can convert a string in base b1 to integer type.
    // Then we can convert the integer type to a string in base b2 using a sequence of multiply and adds.
    // For example, for string is "615", b1 = 7. It is 306.
    // The least significant digit of result is 306 % 13 = 7
    // continue with 306 / 13 = 23, 23 % 13 = 10, denote with 'A'. We continue with 23 / 13 = 1.
    // Since 1 / 13 = 0, the final digit is 1. The overall is "1A7".
    // Since the conversion algorithm is naturally expressed in term of smaller similar subproblems, it is natrual to implement using recursion.

    public static String convertBase(String numAsString, int b1, int b2) {
        int intVal = convertBaseToInt(numAsString, b1);
        return convertBaseToString(intVal, b2);
    }

    // This is positive
    private static String convertBaseToString(int intVal, int b2) {
        StringBuilder sb = new StringBuilder();
        boolean isNeg = false;

        if (intVal < 0) {
            isNeg = true;
        }

        while (intVal != 0) {
            int intdigit = intVal % b2;
            if (isNeg) {
                intdigit = -1 * intdigit;
            }

            char chardigit = intdigit < 10 ? (char) ('0' + intdigit) : (char) ('A' + (intdigit - 10));
            sb.append(chardigit);
            intVal /= b2;
        }

        if (isNeg) {
            sb.append('-');
        }

        return sb.reverse().toString();
    }

    private static int convertBaseToInt(String numAsString, int b1) {
        boolean isNegative = numAsString.startsWith("-");
        int numAsInt = 0;

        for (int i = (isNegative ? 1 : 0); i < numAsString.length(); i++) {
            char digitChar = numAsString.charAt(i);
            int digit = 0;
            if (digitChar >= '0' && digitChar <= '9') {
                digit = digitChar - '0';
            } else {
                digit = digitChar - 'A' + 10;
            }

            if (isNegative) {
                digit = -1 * digit;
            }

            numAsInt = numAsInt * b1 + digit;
        }

        return numAsInt;
    }
}

