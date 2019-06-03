package _10_BinaryTrees;

import common.TreeNode;

/**
 * The lowest common ancestor(LCA) of any two nodes in a binary tree is the node
 * furtheset from the root that is an ancestor of both nodes.
 * Computing LCA has important applications.
 * Rendering webpages, CSS to a DOM element.
 * <p>
 * Design an algorithm for computing the LCA of two nodes in a binary tree
 * in which nodes do not have a parent filed.
 */
public class _3_lowestCommonAncestor {
    public static TreeNode LCA(TreeNode tree, TreeNode node0, TreeNode node1) {
        return LCAHelper(tree, node0, node1).ancestor;
    }

    /**
     * Returns an object consisting of an int and a node.
     * The int filed is 0, 1, 2, depending on how many of {node0, node1} are present
     * in the tree. If both are present in the tree, when ancestor is assigned to
     * a non-null value, it is the LCA.
     * <p>
     * The algorithm is similar to a recursive postorder traversal.
     * T = O(n)
     * S = O(h)
     */
    private static Status LCAHelper(TreeNode tree, TreeNode node0, TreeNode node1) {
        if (tree == null) {
            return new Status(0, null);
        }

        Status leftRes = LCAHelper(tree.left, node0, node1);
        if (leftRes.numTargetNodes == 2) {
            // Found both nodes in the left subtree
            return leftRes;
        }

        Status rightRes = LCAHelper(tree.right, node0, node1);
        if (rightRes.numTargetNodes == 2) {
            // Found both nodes in the right subtree
            return rightRes;
        }

        int numTargetNodes = leftRes.numTargetNodes + rightRes.numTargetNodes + (tree == node0 ? 1 : 0) + (tree == node1 ? 1 : 0);
        return new Status(numTargetNodes, numTargetNodes == 2 ? tree : null);
    }

    /**
     * Hint: when is the root the LCA?
     * If two nodes are in a subtree, we can compute LCA directly.
     * Instead of simply returning a Boolean indicating that both nodes
     * are in that subtree. The program below returns an object with two
     * fields - the first is integer indicating how many of the two nodes were
     * present in that subtree. The second is their LCA if both nodes were present.
     */
    private static class Status {
        public int numTargetNodes;
        public TreeNode ancestor;

        public Status(int numTargetNodes, TreeNode ancestor) {
            this.numTargetNodes = numTargetNodes;
            this.ancestor = ancestor;
        }
    }
}
