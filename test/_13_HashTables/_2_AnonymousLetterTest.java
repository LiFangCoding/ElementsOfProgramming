package _13_HashTables;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class _2_AnonymousLetterTest {

    @Test
    void isLetterConstructibleFromMagazine() {
        assertFalse(_2_AnonymousLetter.isLetterConstructibleFromMagazine("abc", "aaabbbddd"));
        assertTrue(_2_AnonymousLetter.isLetterConstructibleFromMagazine("abc", "aaabbbcddd"));
    }
}