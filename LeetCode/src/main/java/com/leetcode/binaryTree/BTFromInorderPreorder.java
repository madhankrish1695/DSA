package com.leetcode.binaryTree;

import java.util.HashMap;
import java.util.Map;

public class BTFromInorderPreorder {

    private static Map<Integer, Integer> inorderMap = new HashMap<>();
    private static Integer preorderIndex = 0;

    public static void main(String[] args) {
        BTFromInorderPreorder btFromInorderPreorder = new BTFromInorderPreorder();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode root = btFromInorderPreorder.buildTree(preorder, inorder);

        System.out.println("Preorder traversal: " + root);


        preorderIndex = 0;
        inorderMap = new HashMap<>();

        // Non-balanced (right skewed) tree
        int[] preorder2 = {1, 2, 3, 4};
        int[] inorder2 = {1, 2, 3, 4};

        TreeNode root2 = btFromInorderPreorder.buildTree(preorder2, inorder2);

        System.out.print("\nPreorder traversal: " + root2);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, 0, n - 1);
    }

    private TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int data = preorder[preorderIndex++];
        TreeNode node = new TreeNode(data);

        node.left = buildTree(preorder, left, inorderMap.get(data) - 1);
        node.right = buildTree(preorder, inorderMap.get(data) + 1, right);

        return node;
    }
}
