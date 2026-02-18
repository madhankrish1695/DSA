package com.leetcode.binaryTree;


/**
 * Given the root of a complete binary tree, return the number of the nodes in the tree.
 * <p>
 * According to Wikipedia, every level, except possibly the last, is completely filled in a complete binary tree, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
 * <p>
 * Design an algorithm that runs in less than O(n) time complexity.
 */
public class CountCompleteTreeNode {
    public static void main(String[] args) {

        CountCompleteTreeNode countCompleteTreeNode = new CountCompleteTreeNode();
        // Hardcoded Complete Binary Tree
        /*
                1
              /   \
             2     3
            / \   /
           4   5 6
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println("Total Nodes 1: " + countCompleteTreeNode.countNodes1(root));
        System.out.println("Total Nodes 2: " + countCompleteTreeNode.countNodes2(root));
    }

    //Time Complexity: O(log² n)
    //Space Complexity: O(log n)
    public int countNodes2(TreeNode root) {
        if (null == root) return 0;
        int leftHeight = getLeftHeight(root);
        int rightHeight = getRightHeight(root);

        //for 2^ leftHeight use Math.pow(2, leftHeight) or bit operator. 2^ won't work since ^ is XOR operator
        if (leftHeight == rightHeight) return (1 << leftHeight) - 1;

        return countNodes2(root.left) + countNodes2(root.right) + 1;
    }

    private int getLeftHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.left;
        }
        return height;
    }

    private int getRightHeight(TreeNode node) {
        int height = 0;
        while (node != null) {
            height++;
            node = node.right;
        }
        return height;
    }

    //O(n)
    public int countNodes1(TreeNode root) {
        if (null == root) return 0;
        return countNodes1(root.left) + countNodes1(root.right) + 1;
    }
}
