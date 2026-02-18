package com.leetcode.binaryTree;

/**
 * You are given the root of a binary tree containing digits from 0 to 9 only.
 * <p>
 * Each root-to-leaf path in the tree represents a number.
 * <p>
 * For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
 * Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
 * <p>
 * A leaf node is a node with no children.
 */
public class SumRootToLeafNumbers {

    public static void main(String[] args) {

        SumRootToLeafNumbers sumRootToLeafNumbers = new SumRootToLeafNumbers();
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(9);
        root1.right = new TreeNode(0);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(1);

        int result = sumRootToLeafNumbers.sumNumbers(root1);

        System.out.println("Total Sum: " + result);

//                  1
//                 /  \
//                2     3
//                / \     \
//               4   5     6
//                  / \   /
//                 7   8 9
//      124 + 1257 + 1258 + 1369 = 4008

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);

        root.right.right = new TreeNode(6);
        root.right.right.left = new TreeNode(9);

        result = sumRootToLeafNumbers.sumNumbers(root);

        System.out.println("Total Sum: " + result);
    }

    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    public int sumNumbers(TreeNode root, int number) {

        if (root == null) return 0;

        int currentNumber = number * 10 + root.val;

        if (root.left == null && root.right == null) {
            return currentNumber;
        }

        int left = 0;
        int right = 0;

        if (root.left != null)
            left = sumNumbers(root.left, currentNumber);

        if (root.right != null)
            right = sumNumbers(root.right, currentNumber);

        return left + right;
    }

}
