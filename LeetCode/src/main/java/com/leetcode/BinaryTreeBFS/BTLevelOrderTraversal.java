package com.leetcode.BinaryTreeBFS;

import com.leetcode.binaryTree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given the root of a binary tree, return the level order traversal of its nodes' values.
 * (i.e., from left to right, level by level).
 */
public class BTLevelOrderTraversal {

    public static void main(String[] args) {
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

        BTLevelOrderTraversal btLevelOrderTraversal = new BTLevelOrderTraversal();

        List<List<Integer>> levels = btLevelOrderTraversal.levelOrder(root);

        System.out.println("Level Order Traversal: " + levels);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> levelList = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                levelList.add(cur.val);
                if (null != cur.left) q.add(cur.left);
                if (null != cur.right) q.add(cur.right);
            }
            result.add(levelList);
        }
        return result;
    }
}
