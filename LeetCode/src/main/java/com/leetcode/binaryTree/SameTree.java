package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * <p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
public class SameTree {
    public static void main(String[] args) {

        SameTree sameTree = new SameTree();
// -------- Sample Input 1 --------
        // p = [1,2,3]
        TreeNode p1 = new TreeNode(1);
        p1.left = new TreeNode(2);
        p1.right = new TreeNode(3);

        // q = [1,2,3]
        TreeNode q1 = new TreeNode(1);
        q1.left = new TreeNode(2);
        q1.right = new TreeNode(3);

        System.out.println("Trees are same (Example 1): "
                + sameTree.isSameTree(p1, q1)); // true
        System.out.println("Trees are same (Example 1) Itr: "
                + sameTree.isSameTreeItr(p1, q1)); // true

        // -------- Sample Input 2 --------
        // p = [1,2]
        TreeNode p2 = new TreeNode(1);
        p2.left = new TreeNode(2);

        // q = [1,null,2]
        TreeNode q2 = new TreeNode(1);
        q2.right = new TreeNode(2);

        System.out.println("Trees are same (Example 2): "
                + sameTree.isSameTree(p2, q2)); // false

        System.out.println("Trees are same (Example 2) Itr: "
                + sameTree.isSameTreeItr(p2, q2)); // false
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (null == p && null == q) return true;
        if (null == p || null == q) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSameTreeItr(TreeNode p, TreeNode q) {
        Queue<TreeNode> pQueue = new LinkedList<>();
        Queue<TreeNode> qQueue = new LinkedList<>();
        pQueue.offer(p);
        qQueue.offer(q);

        while (!pQueue.isEmpty() && !qQueue.isEmpty()) {
            TreeNode pNode = pQueue.poll();
            TreeNode qNode = qQueue.poll();

            if (pNode == null && qNode == null) continue;

            if (pNode == null || qNode == null) return false;

            if (pNode.val != qNode.val) return false;

            pQueue.offer(pNode.left);
            qQueue.offer(qNode.left);

            pQueue.offer(pNode.right);
            qQueue.offer(qNode.right);

        }

        return true;
    }
}
