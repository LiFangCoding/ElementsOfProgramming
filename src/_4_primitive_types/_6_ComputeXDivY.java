package _4_primitive_types;

public class _6_ComputeXDivY {
    /**
     * O(n)
     * Given two positive integers, compute quotient. Using only addion, substraction and shifting operator.
     * Brute force is to substract y from x until remains is less than y.
     * Complexity is high. eg: when y = 1 and x = 2 ^ 31 -1, it will be 2^31 -1.
     * A better is to try and get more work done in each iteration.
     * Compute the largest k such that 2^k * y <= x. add 2^k to the quotient.
     * It can be efficient and x is at least havled in each iteration.
     * The largest k is decreasing. So we can fist largest, then find small one.
     * individual operation is O(1). Total is O(n)
     */
    public static long divide(long x, long y) {
        long result = 0;
        // y is dividee. The largest power is 32.
        int power = 32;
        long yPower = y << power;
        // Here is x >= y. Not yPower.
        while (x >= y) {
            while (yPower > x) {
                yPower >>>= 1;
                --power;
            }
            result += (1L << power);
            x -= yPower;
        }

        return result;
    }
}
