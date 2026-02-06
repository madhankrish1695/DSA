package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumDepth {

    public static void main(String[] args) {
        MaximumDepth maximumDepth = new MaximumDepth();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        int depth = maximumDepth.maxDepthRec(root);
        System.out.println("Maximum Depth of Binary Tree recursion: " + depth);
        System.out.println("Maximum Depth of Binary Tree recursion: " + maximumDepth.maxDepthItr(root));
    }

    public int maxDepthRec(TreeNode root) {
        if (null == root) return 0;
        int left = maxDepthRec(root.left);
        int right = maxDepthRec(root.right);
        return 1 + Math.max(left, right);
    }

    public int maxDepthItr(TreeNode root) {
        if (null == root) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        return depth;
    }
}
