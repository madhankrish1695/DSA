package com.leetcode.BST;

import com.leetcode.binaryTree.TreeNode;

import java.util.Stack;

/**
 * Given the root of a binary search tree, and an integer k,
 * return the kth smallest value (1-indexed) of all the values of the nodes in the tree.
 */
public class KthSmallestElement {

    public static void main(String[] args) {
        KthSmallestElement kthSmallestElement = new KthSmallestElement();
 /*
                5
               / \
              3   6
             / \
            2   4
           /
          1
        */

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.left.left.left = new TreeNode(1);

        int k = 3;
        int result = kthSmallestElement.kthSmallest(root, k);

        System.out.println("Kth Smallest Element: " + result);
    }

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        while (null != current || !stack.isEmpty()) {
            while (null != current) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            k--;
            if (k == 0) {
                return current.val;
            }
            current = current.right;
        }
        return -1;
    }
}
