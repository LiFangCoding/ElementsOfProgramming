package _10_BinaryTrees;

import common.TreeNode;

/**
 * It is trivial to find the kth node that appears in an inorder traversal with
 * O(n) time complexity, where n is the number of nodes.
 * However, with additional information on each node, you can do better.
 * <p>
 * Write a program that efficiently computes the kth node appearing in an inorder
 * traversal. Assume that each node stores the number of nodes in the subtree
 * rooted at that node.
 */
public class _9_kthNodeInorder {
    // Hint: Use the divide and conquer principle.

    /**
     * If k is greater than the number of nodes in the left subtree,
     * it cannot lie in the left subtree.
     * If left subtree has L nodes, kth node is the (k - L)th node when we skip
     * the left subtree.
     * <p>
     * Understand inorder sequence first.
     * <p>
     * Since we descend the tree in each iteration,
     * T = O(h), h is the height of the tree.
     */
    public static TreeNode findKthNodeBinaryTree(TreeNode tree, int k) {
        TreeNode iter = tree;

        while (iter != null) {
            int leftSize = iter.left != null ? iter.left.size : 0;
            if (leftSize + 1 < k) {
                //k-th node must be in right subtree of iter.
                k -= (leftSize + 1);
                iter = iter.right;
            } else if (leftSize == k - 1) {
                return iter;
            } else {
                //k-th node must be in left subtree of iter.
                iter = iter.left;
            }
        }

        // if k is between 1 and the tree size, this line is unreachable
        return null;
    }
}
