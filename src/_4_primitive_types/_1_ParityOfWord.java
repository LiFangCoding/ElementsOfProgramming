package _4_primitive_types;

public class _1_ParityOfWord {
    /**
     * O(n)
     */
    public static short parity1(long x) {
        short result = 0;
        while (x != 0) {
            result ^= (x & 1);
            x >>>= 1;
        }
        return result;
    }

    /**
     * O(s), where s is the number of bits set to 1 in x
     */
    public static short parity2(long x) {
        short result = 0;
        while (x != 0) {
            result ^= 1;
            /**  x & (x - 1) -> replace the lowest bit of x that is 1 with 0.
             *  if x = (00101100), then x - 1 = (00101011), x& (x - 1) = (00101000)
             *  x & ~(x - 1) -> isolates the lowest bit of x that is 1. all other bits are 0,.
             *  if x = (00101100), then ~(x - 1) = (11010100), x & ~(x - 1) = (00000100)
             */
            x &= (x - 1);
        }
        return result;
    }

    /**
     * If L is the width of words for which cache the results, n is the word size
     * O(n / L). Does not include time for building lookup table.
     * When calcuare alarge number of parity. Using cache.
     * cache for 64 bits, not ok since 2 ^ 64. We can split. using 2 ^ 16 = 65536.
     * After move, we need to use (1* 16) to make out the last 16 bits.
     *
     * @param x
     * @return
     */
    public static short parity3(short x) {
        short[] cacheParity = new short[0xFFFF];

        final int MASK_SIZE = 16;
        // F means four 1 digits.
        final int BIT_MASK = 0xFFFF;

        short firstFourRes = cacheParity[(int) x >>> (3 * MASK_SIZE) & BIT_MASK];
        short secondFourRes = cacheParity[(int) x >>> (2 * MASK_SIZE) & BIT_MASK];
        short thirdFourRes = cacheParity[(int) x >>> (1 * MASK_SIZE) & BIT_MASK];
        short lastFourRes = cacheParity[(int) x & BIT_MASK];

        return (short) (firstFourRes ^ secondFourRes ^ thirdFourRes ^ lastFourRes);
    }

    /**
     * The XOR of a group of bits is its parity.
     * This is like every time just care 32 bits, 16 bits and finally 1 bit. compare 1 & 1 to get result
     * O (log n)
     */
    public static short parity(long x) {
        x ^= x >>> 32;
        x ^= x >>> 16;
        x ^= x >>> 8;
        x ^= x >>> 4;
        x ^= x >>> 2;
        x ^= x >>> 1;
        return (short) (x & 0x1);
    }

    public static void main(String[] args) {
        long x = Long.MAX_VALUE - Integer.MAX_VALUE;
        System.out.println(Long.toBinaryString(x));
        System.out.println(Long.toBinaryString(x >>> 32));
        System.out.println(Long.toBinaryString(x ^ (x >>> 32)));
        System.out.println(parity(x));
    }
}
