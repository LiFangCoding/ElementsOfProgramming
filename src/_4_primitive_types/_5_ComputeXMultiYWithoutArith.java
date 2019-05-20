package _4_primitive_types;

public class _5_ComputeXMultiYWithoutArith {

    /**
     * return the multiply of x and y withour arithmetic
     * Iterate through each bit of x, and then can move the y to the 2 ^ k * y, then we can get the
     * O(n^2)
     * n is number of bits need to represent the operands.
     * Since we do n additions to perform a single multiplication. Total is O(n ^ 2)
     * @param x
     * @param y
     * @return
     */
    public static long multipy(long x, long y) {
        long sum = 0;
        while (x != 0) {
            // Examines each bit of x
            if ((x & 1) != 0) {
                sum = add(sum, y);
            }
            x >>>= 1;
            // This is for the 2^k * y.
            y <<= 1;
        }
        return sum;
    }

    /**
     * O(n)
     * @param a
     * @param b
     * @return
     */
    private static long add(long a, long b) {
        long sum = 0, carryin = 0, k = 1, tempA = a, tempB = b;
        while (tempA != 0 || tempB != 0) {
            long ak = a & k, bk = b & k;
            long carryout = (ak & bk) | (ak & carryin) | (bk & carryin);
            sum |= (ak ^ bk ^ carryin);
            // carryin is one digit but like 1
            carryin = carryout << 1;
            k <<= 1;
            tempA >>>= 1;
            tempB >>>= 1;
        }
        // This is like check carryin.
        return sum | carryin;
    }
}
