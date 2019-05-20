package _4_primitive_types;

public class _2_SwapBits {
    /**
     * Brute force is to use bitmasks. saving them to local variables. using a combination
     * This is for object swap. But bit only has two values. We can optimize.
     * First test if they can be swapped differ.
     * IF different, flipping their individual value.
     *
     * @param x
     * @param i
     * @param j
     * @return
     */
    public static long swapBits(long x, int i, int j) {
        //Extract the ith and jth bits, and see if they differ.
        if (((x >>> i) & 1) != ((x >>> j) & 1)) {
            // Do not have <<< for the unassigned left shift
            long bitmask = ((1 << i) | (1 << j));
            x ^= bitmask;
        }
        return x;
    }
}
