package _9_StacksAndQueues;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Design a stack that includes a max operation, in addition to push and pop.
 * The max method should return the maximum value stored in the stack.
 */
public class _1_ImplementAStackWithMaxAPI {
    // Hint: Use additional storage to track the maximum value.

    /**
     * The simplest way to implement a max operation is to consider each element in the stack, eg: by iterating
     * through the underlying array for an array based stack.
     * T = O(n), S = O(1)
     *
     * The T can be reduced to O(log n) using auxiliary data structures, a heap or a BST and a hash table.
     * T = O(log n).  S = O(n)
     *
     * Suppose we use a variable M to record element that is maximum in the stack.
     * Updating M on pushes is easy: M = max(M , e), e is element being pushed
     * Updating M on pop is time consuming. If M is the element being popped, we have no way of knowing the maximum
     * element is and are forced to consider all remaining elements.
     *
     * We can improve T by caching, in essence, trading time for space. Specifically, for each entry in the stack,
     * we cache the maximum stored at or below that entry. Now, when we pop, we evict the corresponding cached value.
     * T = O(1)
     * S = O(n)
     *
     * The idea is for push element, make it has max value. Using ElementWithCachedMax class.
     */

    static class cacheElementInEleClass {
        private static class ElementWithCachedMax {
            public Integer element;
            public Integer max;

            public ElementWithCachedMax(Integer element, Integer max) {
                this.element = element;
                this.max = max;
            }
        }

        // all methods T = O(1)
        // S = O(n)
        public static class Stack {
            // Stores (element, cached maximum) pair.
            private Deque<ElementWithCachedMax> elementWithCachedMaxes = new LinkedList<>();

            public boolean empty() {
                return elementWithCachedMaxes.isEmpty();
            }

            public Integer max() {
                if (empty()) {
                    throw new IllegalStateException("max() : empty stack");
                }
                return elementWithCachedMaxes.peek().max;
            }

            public Integer pop() {
                if (empty()) {
                    throw new IllegalStateException("pop() : empty stack");
                }
                return elementWithCachedMaxes.removeFirst().element;
            }

            // linkedlist the addFirst is O(1) time complexity.
            public void push(Integer x) {
                elementWithCachedMaxes.addFirst(new ElementWithCachedMax(x, Math.max(x, empty() ? x : max())));
            }
        }
    }

    /**
     * We can improve on the best-case space needed by observing that if an element e being pushed
     * is smaller than the maximum already in the stack, the ne can never be the maximum, so we do not
     * need to record it.
     * if maximum is same with pushed node, we just push that in the maximum stack.
     *
     * The worst-case additional space complexity is O(n), which occurs when each key pushed is greater than all
     * keys in the primary stack.
     * When the maximum changes infrequenctly, the additional space complexity is less, O(1) is the best-case.
     * For each specified method, T = O(1).
     */
}
