package _12_Searching;

import common.ListAndArray;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class _1_SearchSortedArrayTest {

    @Test
    void searchFirstOfK() {
        int[] A = {-14, -10, -10, 22, 22, 22};
        assertEquals(0, _1_SearchSortedArray.searchFirstOfK(ListAndArray.ArrayToList(A), -14));
        assertEquals(1, _1_SearchSortedArray.searchFirstOfK(ListAndArray.ArrayToList(A), -10));
        assertEquals(3, _1_SearchSortedArray.searchFirstOfK(ListAndArray.ArrayToList(A), 22));
    }
}