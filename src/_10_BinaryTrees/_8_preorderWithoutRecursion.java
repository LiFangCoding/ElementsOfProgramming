package _10_BinaryTrees;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Write a program which takes as input a binary tree and
 * performs preorder traversal of tree. Do not use recursion.
 * Nodes do not contain parent references.
 */
public class _8_preorderWithoutRecursion {
    /**
     * a preorder traversal visists nodes in a last in, first out order.
     * We can perform the preorder traversal using a stack of tree nodes.
     * The stack is initialized to contain the root.
     * We visit a node by popping it, adding first its right child, and then
     * its left child to the stack. (We add the left child after the right child, since
     * we want to continue with the left child.)
     * <p>
     * We can simulate the stack states and see the result.
     * T = O(n)
     * S = O(h)
     */
    public static List<Integer> preorderTraversal(TreeNode tree) {
        Deque<TreeNode> path = new LinkedList<>();
        path.addFirst(tree);
        List<Integer> res = new ArrayList<>();

        while (!path.isEmpty()) {
            TreeNode cur = path.removeFirst();
            if (cur != null) {
                res.add(cur.val);
                path.addFirst(cur.right);
                path.addFirst(cur.right);
            }
        }
        return res;
    }
}
