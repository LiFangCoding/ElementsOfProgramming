package _17_DynamicProgramming;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _2_ComputeTheLevenshteinDistanceTest {

    @Test
    void levenshteinDistance() {
        assertEquals(8, _2_ComputeTheLevenshteinDistance.levenshteinDistance("Carthorse", "Orchestra"));
        assertEquals(2, _2_ComputeTheLevenshteinDistance.levenshteinDistance("apple", "bppl"));
    }
}