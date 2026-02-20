package com.leetcode.BinaryTreeBFS;

import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the zigzag level order traversal of its nodes' values.
 * (i.e., from left to right, then right to left for the next level and alternate between).
 */
public class BTZigZagLevelOrder {

    public static void main(String[] args) {
        BTZigZagLevelOrder btZigZagLevelOrder = new BTZigZagLevelOrder();
        /*
                3
               / \
              9   20
                 /  \
                15   7
        */

        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = btZigZagLevelOrder.zigzagLevelOrder(root);

        System.out.println("Zigzag Level Order: " + result);
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean leftToRight = true;

        while (!q.isEmpty()) {
            int size = q.size();
            LinkedList<Integer> levelList = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (leftToRight) {
                    levelList.addLast(cur.val);
                } else {
                    levelList.addFirst(cur.val);
                }

                if (null != cur.left) q.offer(cur.left);
                if (null != cur.right) q.offer(cur.right);
            }
            result.add(levelList);
            leftToRight = !leftToRight;
        }

        return result;
    }
}
