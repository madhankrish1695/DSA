package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public static void main(String[] args) {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        // -------- Example 1 --------
        // root = [4,2,7,1,3,6,9]
        TreeNode root1 = new TreeNode(4);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(7);
        root1.left.left = new TreeNode(1);
        root1.left.right = new TreeNode(3);
        root1.right.left = new TreeNode(6);
        root1.right.right = new TreeNode(9);

        System.out.println("Input: " + root1);

        TreeNode node1 = invertBinaryTree.invertTree(root1);
        System.out.println("Inverted Tree: " + node1);
        invertBinaryTree.invertTreeInPlaceDFS(root1);
        System.out.println("Inverted Tree DFS: " + root1);
        invertBinaryTree.invertTreeInPlaceBFS(root1);
        System.out.println("Inverted Tree BFS: " + root1);

        // -------- Example 2 --------
        // root = [2,1,3]
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);

        System.out.println("Input: " + root2);

        TreeNode node2 = invertBinaryTree.invertTree(root2);
        System.out.println("Inverted Tree: " + node2);
        invertBinaryTree.invertTreeInPlaceDFS(root2);
        System.out.println("Inverted Tree DFS: " + root2);
        invertBinaryTree.invertTreeInPlaceBFS(root2);
        System.out.println("Inverted Tree BFS: " + root2);
    }

    public TreeNode invertTree(TreeNode root) {
        if (null == root)
            return null;

        TreeNode result = new TreeNode(root.val);
        result.left = invertTree(root.right);
        result.right = invertTree(root.left);

        return result;
    }

    public TreeNode invertTreeInPlaceDFS(TreeNode root) {
        if (null == root) return null;

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        invertTreeInPlaceDFS(root.right);
        invertTreeInPlaceDFS(root.left);

        return root;
    }

    public TreeNode invertTreeInPlaceBFS(TreeNode root) {
        if (null == root) return null;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) q.offer(node.left);
            if (node.right != null) q.offer(node.right);
        }

        return root;
    }
}
