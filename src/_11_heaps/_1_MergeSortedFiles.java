package _11_heaps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * This problem is motivated by the following scenario. You are given 500 files, each containing stock trade information for an S&P 500 company. Each trade is encoded bya linein thefollowingformat: 1232111,AAPL,38,456.12.
 * The first number is the time of the trade expressed as the number of milliseconds since the start of the day's trading.
 * Lines within each file are sorted in increasing order of time. The remaining values are the stock symbol, number of shares, and price.
 * You are to create a single file containing all the trades from the 500 files, sorted in order of increasing trade times. The individual files are of the order of 5-100 megabytes; the combined file will be of the order of five gigabytes.
 * In the abstract, we are trying to solve the following problem.
 * Write a program that takes as input a set of sorted sequences and computes the union of these sequences as a sorted sequence.
 * For example, if the input is (3, 5, 7), (0, 6), and (0, 6, 28), then the output is (0, 0, 3, 5, 6, 6, 7, 28).
 */
public class _1_MergeSortedFiles {
    // Hint: which part of each sequence is significant as the algorithm executes/

    /**
     * The brute-force approach is to concatenate these sequences into a single array and then sort it.
     * T = O(n * logn), assuming n elements in total.
     * <p>
     * The brute-force approach does not use the fact that individual sequences are sorted.
     * We can take advantage of this fact by restricting our attention to the first remaining element in each sequence.
     * Specifically, we repeatedly pick the smallest element amongest the first element of each of the remaining part of each of
     * the sequences.
     * A min-heap is ideal for maintaining a collection of elements when we need to add arbitrary values and extract the smallest value.
     * <p>
     * For a sequence, we need the the element in which array.
     * ex:  <3,5,7>, <0, 6>, <0, 6, 28>.
     * <p>
     * Let k be the number of input sequences. Then there are no more than k elements in the min-heap.
     * Both extra-min and insert take O(logk) time.
     * merge is done T = O(nlogk).
     * S = O(k).
     * <p>
     * we can also recursively merge the k files. two at a time using the merge step from merge sort.
     * We go from k to k / 2 then k /4, etc, files. There would be logk stages. Each has time complexity O(n).
     * T = O(nlogk)
     * S = O(n). which is considerably worse than the heap based approach when k << n.
     */
    public static List<Integer> mergeSortedArrays(List<List<Integer>> sortedArrays) {
        List<Iterator<Integer>> iters = new ArrayList<>(sortedArrays.size());

        for (List<Integer> array : sortedArrays) {
            iters.add(array.iterator());
        }

        PriorityQueue<ArrayEntry> minHeap = new PriorityQueue<>(sortedArrays.size(), (o1, o2) -> Integer.compare(o1.value, o2.value));

        // This is for the iters for all sorted array. add their heads into heap if have.
        for (int i = 0; i < iters.size(); i++) {
            if (iters.get(i).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(i).next(), i));
            }
        }

        List<Integer> res = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            ArrayEntry headEntry = minHeap.poll();
            res.add(headEntry.value);
            if (iters.get(headEntry.arrayId).hasNext()) {
                minHeap.add(new ArrayEntry(iters.get(headEntry.arrayId).next(), headEntry.arrayId);
            }
        }
        return res;
    }

    private static class ArrayEntry {
        public Integer value;
        public Integer arrayId;

        public ArrayEntry(Integer value, Integer arrayId) {
            this.value = value;
            this.arrayId = arrayId;
        }
    }
}
