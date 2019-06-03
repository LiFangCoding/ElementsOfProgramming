package _7_Strings;

/**
 * Consider the following two rules that are to be applied to an array of characters.
 * Replace each 'a' by two 'd's.
 * Delete each entry containing a 'b'.
 * For example, applying these rules to the array (a,c,d,b,b,c,a) results in the array (d, d, c, d, c, d, d).
 */
public class _4_replaceAndRemove {
    // Hint: Consider performing multiples passes on s.

    /**
     * if we insert into a specific location(all later shift right) and delete from a specific location (all later shift right).
     * T = O(n ^ 2), n is the array's length.
     * <p>
     * The problem is trivial to solve in O(n) if we write result to a new arary.
     * T = O(n), S = O(n)
     * <p>
     * One good solution is T = O(n). S = O(1)
     * First, we delete b's and compute the final number of valid characters of string. Then we replace each 'a' by two 'd's.
     * iterating from the end of the resulting string.
     */
    // size the number of entries of the array that operation is to be applied to.
    public static int replaceAndRemove(int size, char[] s) {
        // Forward iteration: remove "b"s and count the number of "a"s.
        // array delete method quick way
        int writeIdx = 0, aCount = 0;
        for (int i = 0; i < size; i++) {
            if (s[i] != 'b') {
                s[writeIdx++] = s[i];
            }

            if (s[i] == 'a') {
                aCount++;
            }
        }

        // backward iteration: replace "a"s with "dd"s starting from the end.
        // array insert method quick way
        int curIdx = writeIdx - 1;
        writeIdx += aCount - 1;
        int finalSize = writeIdx + 1;

        while (curIdx >= 0) {
            if (s[curIdx] == 'a') {
                s[writeIdx--] = 'd';
                s[writeIdx--] = 'd';
            } else {
                s[writeIdx--] = s[curIdx];
            }
            curIdx--;
        }
        return finalSize;
    }
}
