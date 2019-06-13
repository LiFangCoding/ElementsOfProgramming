package _18_GreedyAlgAndInvariants;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _5_FindMajorityElementTest {
    List<String> list = Arrays.asList("b", "a", "c", "b", "a", "a");

    @Test
    void majoritySearch() {
        assertEquals("a", _5_FindMajorityElement.majoritySearch(list.iterator()));
    }
}