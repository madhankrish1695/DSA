package com.leetcode.BST;

import com.leetcode.binaryTree.TreeNode;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 * <p>
 * A valid BST is defined as follows:
 * <p>
 * The left subtree of a node contains only nodes with keys strictly less than the node's key.
 * The right subtree of a node contains only nodes with keys strictly greater than the node's key.
 * Both the left and right subtrees must also be binary search trees.
 */
public class ValidateBST {

    public static void main(String[] args) {
        ValidateBST validateBST = new ValidateBST();

        /*
                5
               / \
              1   7
                 / \
                4   8
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(8);

        System.out.println("Is Valid BST: " + validateBST.isValidBST(root));
    }

    public boolean isValidBST(TreeNode root) {
        //return isValidBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE); it won't work if node value is Integer.MAX_VALUE. It will return false
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((null != min && min >= root.val) || (null != max && max <= root.val)) {
            return false;
        }

        return isValidBST(root.left, min, root.val) && isValidBST(root.right, root.val, max);
    }
}
