package _5_primitive_types;

public class _4_findAClosestInt {
    /**
     * return same weight int but closest.
     * flip index k1 and k2, k1 > k2. The difference is 2 ^ k1 - 2 ^ k2.
     * So we want k1 as small as possible. k2 is very close to k1.
     * Also, preserve weight, k1 and k2 must be different.
     * So smallest k1 is the rightmost bit that is different from LSB (if it is on LSB,
     * there is no k2 at right).
     * k2 must be the very next bit.
     * The solution is to swap the two rightmost consecutive bits that differ.
     *
     * @param x nonnegative
     */
    public static long cloestIntSameBitCount(long x) {
        final int NUM_UNSIGNED_BITS = 63;
        // x is non-negative. we can know leading bit is 0.
        for (int i = 1; i <= NUM_UNSIGNED_BITS; i++) {
            long k1 = (x >>> i) & 1;
            long k2 = (x >>> (i - 1)) & 1;
            if (k1 != k2) {
                long mask = (1 << i) | (1 << (i - 1));
                x ^= mask;
                // after find, return directly
                return x;
            }
        }
        return Long.parseLong(null);
    }
}

