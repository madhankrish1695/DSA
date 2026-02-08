package com.leetcode.binaryTree;


import java.util.HashMap;
import java.util.Map;

/**
 * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and
 * postorder is the postorder traversal of the same tree, construct and return the binary tree.
 */
public class BTFromInorderPostorder {

    private int postIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public static void main(String[] args) {
        BTFromInorderPostorder btFromInorderPostorder = new BTFromInorderPostorder();
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode root = btFromInorderPostorder.buildTree(inorder, postorder);

        System.out.print("preorder traversal: " + root);
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n = postorder.length;
        postIndex = n - 1;
        inorderMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(postorder, 0, n - 1);
    }

    public TreeNode buildTree(int[] postorder, int left, int right) {
        if (left > right) return null;

        TreeNode node = new TreeNode(postorder[postIndex--]);

        node.right = buildTree(postorder, inorderMap.get(node.val) + 1, right);
        node.left = buildTree(postorder, left, inorderMap.get(node.val) - 1);

        return node;
    }
}
