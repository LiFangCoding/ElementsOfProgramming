package _19_Graphs;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _7_TransformOneStringToAnotherTest {
    private int expected;
    private Set<String> D;
    private String s;
    private String d;

    @Test
    void transformstring() {
        D = new HashSet<>(Arrays.asList(
                "bat",
                "cot",
                "dog",
                "dag",
                "dot",
                "cat"
        ));
        s = "cat";
        d = "dog";

        assertEquals(3, _7_TransformOneStringToAnother.transformstring(D, s, d));
    }

    @Test
    void transformstring2() {
        D = new HashSet<>(Arrays.asList(
                "cat",
                "cot",
                "dot",
                "dag"
        ));
        s = "cat";
        d = "dog";

        assertEquals(-1, _7_TransformOneStringToAnother.transformstring(D, s, d));
    }
}