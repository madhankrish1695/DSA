package com.leetcode.BST;

import com.leetcode.binaryTree.TreeNode;

import java.util.Stack;

/**
 * Given the root of a Binary Search Tree (BST),
 * return the minimum absolute difference between the values of any two different nodes in the tree.
 */
public class MinimumAbsoluteDifference {

    public static void main(String[] args) {
        MinimumAbsoluteDifference minimumAbsoluteDifference = new MinimumAbsoluteDifference();
        /*
                4
               / \
              2   6
             / \
            1   3
        */

        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        int result = minimumAbsoluteDifference.getMinimumDifference(root);

        System.out.println("Minimum Absolute Difference: " + result);
    }

    public int getMinimumDifference(TreeNode root) {
        int min = Integer.MAX_VALUE;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        Integer prev = null;
        while (!stack.isEmpty() || current != null) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();

            if (null != prev) {
                min = Math.min(min, current.val - prev);
            }

            prev = current.val;
            current = current.right;
        }
        return min;
    }
}
