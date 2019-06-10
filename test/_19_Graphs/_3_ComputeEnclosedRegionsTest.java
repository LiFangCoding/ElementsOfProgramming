package _19_Graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _3_ComputeEnclosedRegionsTest {
    private final Character w = 'W';
    private final Character b = 'B';
    private List<List<Character>> expected;
    private List<List<Character>> board;

    @Test
    void fillSurroundedRegions() {
        expected = Arrays.asList(
                Arrays.asList(b, b, b, b),
                Arrays.asList(w, b, b, b),
                Arrays.asList(b, b, b, b),
                Arrays.asList(b, b, b, b)
        );

        board = Arrays.asList(
                Arrays.asList(b, b, b, b),
                Arrays.asList(w, b, w, b),
                Arrays.asList(b, w, w, b),
                Arrays.asList(b, b, b, b)
        );

        _3_ComputeEnclosedRegions.fillSurroundedRegions(board);
        assertEquals(expected, board);
    }
}