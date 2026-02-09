package com.leetcode.binaryTree;

/**
 * Given the root of a binary tree, flatten the tree into a "linked list":
 * <p>
 * The "linked list" should use the same TreeNode class where the right child pointer points to the next node in the list
 * and the left child pointer is always null.
 * The "linked list" should be in the same order as a pre-order traversal of the binary tree.
 */
public class FlattenBinaryTee {

    public static void main(String[] args) {
        FlattenBinaryTee flattenBinaryTee = new FlattenBinaryTee();
        TreeNode root = flattenBinaryTee.getInput();
        flattenBinaryTee.flatten(root);
        flattenBinaryTee.print(root);

        root = flattenBinaryTee.getInput();
        flattenBinaryTee.flattenRecursion(root);
        flattenBinaryTee.print(root);
    }

    private TreeNode getInput() {
                /*
            Sample Binary Tree:
                    1
                   / \
                  2   5
                 / \   \
                3   4   6

            Expected Linked List (right pointers):
            1 -> 2 -> 3 -> 4 -> 5 -> 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(6);
        return root;
    }

    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (null != cur) {
            if (null != cur.left) {
                TreeNode pred = cur.left;
                while (pred.right != null) {
                    pred = pred.right;
                }
                pred.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }

    private TreeNode prev = null;

    private void flattenRecursion(TreeNode root) {
        if (null == root) return;

        flattenRecursion(root.right);
        flattenRecursion(root.left);

        root.right = prev;
        root.left = null;
        prev = root;


    }

    private void print(TreeNode root) {
        TreeNode curr = root;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.right;
        }
    }
}
