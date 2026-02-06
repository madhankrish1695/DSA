package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).
 */
public class SymmetricTree {

    public static void main(String[] args) {
        SymmetricTree symmetricTree = new SymmetricTree();
        // -------- Example 1 (Symmetric) --------
        // root = [1,2,2,3,4,4,3]
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
        root1.right = new TreeNode(2);
        root1.left.left = new TreeNode(3);
        root1.left.right = new TreeNode(4);
        root1.right.left = new TreeNode(4);
        root1.right.right = new TreeNode(3);

        System.out.println("DFS Symmetric: " + symmetricTree.isSymmetric(root1)); // true
        System.out.println("BFS Symmetric: " + symmetricTree.isSymmetricBFS(root1)); // true

        // -------- Example 2 (Not Symmetric) --------
        // root = [1,2,2,null,3,null,3]
        TreeNode root2 = new TreeNode(1);
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(2);
        root2.left.right = new TreeNode(3);
        root2.right.right = new TreeNode(3);

        System.out.println("DFS Symmetric: " + symmetricTree.isSymmetric(root2)); // false
        System.out.println("BFS Symmetric: " + symmetricTree.isSymmetricBFS(root2)); // false
    }

    public boolean isSymmetric(TreeNode root) {
        return isSymmetricDFS(root.left, root.right);
    }

    public boolean isSymmetricDFS(TreeNode left, TreeNode right) {
        if (null == left && null == right) return true;
        if (null == left || null == right) return false;
        if (left.val != right.val) {
            return false;
        }
        return isSymmetricDFS(left.left, right.right) && isSymmetricDFS(left.right, right.left);
    }

    public boolean isSymmetricBFS(TreeNode root) {
        if (root == null) return false;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root.left);
        q.offer(root.right);

        while (!q.isEmpty()) {
            TreeNode left = q.poll();
            TreeNode right = q.poll();

            if (null == left && null == right) return true;
            if (null == left || null == right) return false;
            if (left.val != right.val) return false;

            q.offer(left.left);
            q.offer(right.right);

            q.offer(left.right);
            q.offer(right.left);

        }

        return true;
    }
}
