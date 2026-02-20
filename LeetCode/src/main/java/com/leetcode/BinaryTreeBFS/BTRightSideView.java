package com.leetcode.BinaryTreeBFS;

import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BTRightSideView {

    public static void main(String[] args) {
        BTRightSideView btRightSideView = new BTRightSideView();

        /*
                1
              /   \
             2     3
              \     \
               5
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        //root.right.right = new TreeNode(4);

        List<Integer> view = btRightSideView.rightSideView(root);

        System.out.println("Right Side View: " + view);

        List<Integer> result = new ArrayList<>();
        btRightSideView.rightSideView(root, 0, result);

        System.out.println("Right Side View: " + result);
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    result.add(cur.val);
                }
                if (null != cur.right) queue.add(cur.right);
                if (null != cur.left) queue.add(cur.left);
            }
        }

        return result;
    }

    public void rightSideView(TreeNode root, int depth, List<Integer> result) {
        if (root == null) return;

        if (depth == result.size()) {
            result.add(root.val);
        }

        rightSideView(root.right, depth + 1, result);
        rightSideView(root.left, depth + 1, result);
    }
}
