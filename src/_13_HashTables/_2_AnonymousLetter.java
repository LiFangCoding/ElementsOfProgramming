package _13_HashTables;

import java.util.HashMap;
import java.util.Map;

/**
 * Write a program which takes text for an anonymous letter and text for a magazine and determines if it is possible to write the anonymous letter using the magazine.
 * The anonymous letter can be written using the magazine if for each character in the anonymous letter,
 * the number of times it appears in the anonymous letter is no more than the number of times it appears in the magazine.
 */
public class _2_AnonymousLetter {
    // Hint: count the number of distinct characters appearing in the letter.
    /**
     * A better approach is to make a single pass over the letter, storing the character counts for the letter in a
     * single hash table - keys are characters, and values are the number of time that character appears.
     * Next we make a pass over the magazine.
     * When processing a character c, if c appears in the hashtable, we reduce its count by 1.
     * <p>
     * In the worst case, if letter is not constructible or the last character of the magazine is essentially required,
     * T = O(m + n)
     * S = O(L), L is the number of distinct characters appearing in the letter.
     */
    public static boolean isLetterConstructibleFromMagazine(String letterText, String magazineText) {
        // char -> freq
        Map<Character, Integer> map = new HashMap<>();
        // Compute the frequencies for all chars in letter Text
        for (char c : letterText.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        //check if the characters in magazineText can cover characters in letterText
        // "aab"  map: ([a,2], [b, 1])
        // "aaabbcd"
        for (char c : magazineText.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) {
                    map.remove(c);
                }

                if (map.size() == 0) {
                    break;
                }
            }
        }

        return map.isEmpty();
    }
}
