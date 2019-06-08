package _5_primitive_types;

/**
 * Write a program that takes a double x and an integer y and returns x^y. You can ignore overflow and underflow.
 */
public class _7_ComputeXPowerY {
    // Hint: Exploit mathematical properties of exponentiation.

    /**
     * First, assume y is nonnegative. The brute-froce is to x^2 = x * x, x ^3 = x ^ 2 * x.
     * This takes y - 1 multiplications, which is O(2^n). where n is the of bits in the integer type.
     * <p>
     * Instead of every time one multiplication, we can do better by
     * x^y = (x ^ (y / 2)) ^ 2 or x * ((x ^ (y / 2)) ^ 2)
     * <p>
     * T = O(log y)
     */
    public static double power(double x, int y) {
        double res = 1.0;
        long power = y;

        if (y < 0) {
            power = -power;
            x = 1.0 / x;
        }

        while (power != 0) {
            if ((power & 1) != 0) {
                res *= x;
            }

            x *= x;
            power >>>= 1;
        }

        return res;
    }
}
