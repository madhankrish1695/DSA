package com.leetcode.binaryTree;


/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 * <p>
 * According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q
 * as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”
 */
public class LowestCommonAncestorBT {

    public static void main(String[] args) {
        LowestCommonAncestorBT lowestCommonAncestorBT = new LowestCommonAncestorBT();

             /*
                  3
                 / \
                5   1
               / \ / \
              6  2 0  8
                / \
               7   4
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);

        TreeNode p = root.left;  // Node 5
        TreeNode q = root.left.right.right;  // Node 4

        TreeNode lca = lowestCommonAncestorBT.lowestCommonAncestor(root, p, q);

        System.out.println("LCA: " + lca.val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (null == root || root.val == p.val || root.val == q.val) {
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if (left != null && right != null) {
            return root;
        }

        return null != left ? left : right;
    }
}
