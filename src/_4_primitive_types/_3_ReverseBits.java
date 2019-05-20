package _4_primitive_types;

public class _3_ReverseBits {
    /**
     * O(n / L). n bit integr, L-bit cache keys
     * Brute force: using _2_SwapBits method to swap each index bit. swap is using flip bit. ^ with bitmask.
     * If the operation is repeatedly performed, using cache 16 bit loop up array as before.
     * For Every 16 bits number y, A[y] holds the bit-reversal of y.
     * Example: (10010011) -> rev(11), rev(00), rev(01), rev(10)
     */
    public static long reverseBits(long x) {
        long[] cacheReverse = new long[1 << 16];

        final int MASK_SIZE = 16;
        final int BIT_MASK = 0xFFFF;

        long firstRev = cacheReverse[(int) (x >>> (MASK_SIZE * 3))];
        long secondRev = cacheReverse[(int) (x >>> (MASK_SIZE * 2)) & BIT_MASK];
        long thirdRev = cacheReverse[(int) x >>> (MASK_SIZE * 1) & BIT_MASK];
        long fourthRev = cacheReverse[(int) x & BIT_MASK];

        // | can be used for add in bits.
        return (fourthRev << (MASK_SIZE * 3)) |
                ((thirdRev) << (MASK_SIZE * 2)) |
                ((secondRev) << (MASK_SIZE * 1)) |
                firstRev;
    }

    //TODO
    private long[] getCacheReverse() {
        return new long[0];
    }
}

