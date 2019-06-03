package _8_LinkedList;

import common.ListNode;

/**
 * Assume two single LinkedList are sorted, ie numbers in the lists appear in ascending order within each list.
 * The merge of two lists is a list consisting of the nodes of the two lists in which numbers appear in ascending order.
 * <p>
 * l1 -> 2->5->7
 * l2 -> 3-> 11
 * r -> 2->3->5->7->11
 * <p>
 * write a program that takes two lists, assume to be sorted and return their merge. The linked list node address is no change.
 */

public class _1_MergeTwoSortedList {
    // Hint: Two sorted arrays can be merged using two indices. For lists, take care when one iterator reaches the end.

    /**
     * A naive approach is to append together and then sort the resulting list.
     * T = O((n + m) * log(n + m))
     * A better approach is to traverse two lists, always choosing the smaller key to continue.
     * T = O(n + m)
     */
    public static ListNode mergeTwoSortedList(ListNode L1, ListNode L2) {
        // create a placeholder for the res.
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        ListNode p1 = L1, p2 = L2;

        while (p1 != null && p2 != null) {
            if (p1.val <= p2.val) {
                curr.next = p1;
            } else {
                curr.next = p2;
                p2 = p2.next;
            }
            // This is to move curr
            curr = curr.next;
        }

        // Append the remaining nodes of p1 or p2
        curr.next = p1 != null ? p1 : p2;
        return dummy.next;
    }
}
