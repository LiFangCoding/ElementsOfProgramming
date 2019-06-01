package _10_BinaryTrees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a program which takes as input a binary tree and
 * performs an inorder traversal of the tree.
 * Do not use recursion. Nodes do not contain parent references.
 */
public class _7_InorderWithoutRecursion {
    // Hint: sumulate the function call stack.

    /**
     * The recursive solution is trivial - first traverse the left subtree,
     * then visit the root, and finally traverse the right subtree.
     * The algorithm can be converted to a iterative algorithm
     * by using an explicit stack.
     * The one below is noteworthy in that it pushes the currentnode,
     * and not its right child.Furthermore, it does not use a visited filed.
     * <p>
     * We can check it by using a small tree.
     * Stack states are <A>, <A, B>, something like that.
     * T = O(n)
     * S = O(h)
     */
    public static List<Integer> BSTInSortedOrder(TreeNode tree) {
        Deque<TreeNode> s = new LinkedList();

        TreeNode cur = tree;
        List<Integer> res = new ArrayList<>();

        while (!s.isEmpty() || cur != null) {
            if (cur != null) {
                s.addFirst(cur);
                // Going left
                cur = cur.left;
            } else {
                // Going up
                cur = s.removeFirst();
                res.add(cur.val);
                // Going right
                cur = cur.right;
            }
        }
        return res;
    }
}
