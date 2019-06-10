package _19_Graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _2_PaintABooleanMatrixTest {
    private final Boolean w = true;
    private final Boolean b = false;
    private List<List<Boolean>> expected;
    private List<List<Boolean>> A;
    private int x;
    private int y;


    @Test
    void flipColorBFS() {
        expected = Arrays.asList(
                Arrays.asList(b, w, b, w, w, w, b, b, b, b),
                Arrays.asList(w, w, b, w, w, b, w, w, b, b),
                Arrays.asList(b, b, b, w, w, b, b, w, b, b),
                Arrays.asList(w, b, w, b, b, b, b, w, b, w),
                Arrays.asList(b, b, b, b, b, b, b, b, w, w),
                Arrays.asList(b, b, b, b, b, b, b, b, b, b),
                Arrays.asList(b, b, b, b, b, b, b, w, w, b),
                Arrays.asList(b, b, b, b, b, b, b, w, w, w),
                Arrays.asList(b, b, b, b, b, b, b, b, b, b),
                Arrays.asList(b, b, b, b, b, b, b, b, b, w)
        );
        A = Arrays.asList(
                Arrays.asList(b, w, b, w, w, w, b, b, b, b),
                Arrays.asList(w, w, b, w, w, b, w, w, b, b),
                Arrays.asList(b, b, b, w, w, b, b, w, b, b),
                Arrays.asList(w, b, w, b, b, b, b, w, b, w),
                Arrays.asList(b, w, b, w, w, w, w, b, w, w),
                Arrays.asList(b, w, b, w, w, b, w, b, b, b),
                Arrays.asList(w, w, w, w, b, w, b, w, w, b),
                Arrays.asList(b, w, b, w, b, w, b, w, w, w),
                Arrays.asList(b, w, b, b, w, w, w, b, b, b),
                Arrays.asList(w, w, w, w, w, w, w, b, b, w)
        );

        x = 5;
        y = 4;

        _2_PaintABooleanMatrix.flipColorBFS(A, x, y);
        assertEquals(expected, A);
    }

    @Test
    void flipColorDFS() {
        expected = Arrays.asList(
                Arrays.asList(b, w, b, w, w, w, b, b, b, b),
                Arrays.asList(w, w, b, w, w, b, w, w, b, b),
                Arrays.asList(b, b, b, w, w, b, b, w, b, b),
                Arrays.asList(w, b, w, b, b, b, b, w, b, w),
                Arrays.asList(b, b, b, b, b, b, b, b, w, w),
                Arrays.asList(b, b, b, b, b, b, b, b, b, b),
                Arrays.asList(b, b, b, b, b, b, b, w, w, b),
                Arrays.asList(b, b, b, b, b, b, b, w, w, w),
                Arrays.asList(b, b, b, b, b, b, b, b, b, b),
                Arrays.asList(b, b, b, b, b, b, b, b, b, w)
        );
        A = Arrays.asList(
                Arrays.asList(b, w, b, w, w, w, b, b, b, b),
                Arrays.asList(w, w, b, w, w, b, w, w, b, b),
                Arrays.asList(b, b, b, w, w, b, b, w, b, b),
                Arrays.asList(w, b, w, b, b, b, b, w, b, w),
                Arrays.asList(b, w, b, w, w, w, w, b, w, w),
                Arrays.asList(b, w, b, w, w, b, w, b, b, b),
                Arrays.asList(w, w, w, w, b, w, b, w, w, b),
                Arrays.asList(b, w, b, w, b, w, b, w, w, w),
                Arrays.asList(b, w, b, b, w, w, w, b, b, b),
                Arrays.asList(w, w, w, w, w, w, w, b, b, w)
        );

        x = 5;
        y = 4;

        _2_PaintABooleanMatrix.flipColorDFS(A, x, y);
        assertEquals(expected, A);
    }
}