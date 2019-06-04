package common;

import java.util.ArrayList;
import java.util.List;

public class ListAndArray {
    public static List<Integer> ArrayToList(int[] A) {
        List<Integer> res = new ArrayList<>();
        for (int val : A) {
            res.add(val);
        }
        return res;
    }
}
