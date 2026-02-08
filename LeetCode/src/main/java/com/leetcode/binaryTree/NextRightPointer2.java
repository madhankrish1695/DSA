package com.leetcode.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * <p>
 * Initially, all next pointers are set to NULL.
 */
public class NextRightPointer2 {

    public static void main(String[] args) {
        NextRightPointer2 nextRightPointer2 = new NextRightPointer2();
        printLevels(nextRightPointer2.connectQueue(nextRightPointer2.getInput()));
        printLevels(nextRightPointer2.connect(nextRightPointer2.getInput()));
        printLevels(nextRightPointer2.connectRecursive(nextRightPointer2.getInput()));
    }

    private Node getInput() {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        root.left.left = new Node(4);
        root.left.right = new Node(5);

        root.right.right = new Node(7);
        return root;
    }

    public Node connectQueue(Node root) {
        if (null == root) return null;
        Queue<Node> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;

            for (int i = 0; i < size; i++) {
                Node current = q.poll();

                if (prev != null) prev.next = current;

                if (current.left != null) q.offer(current.left);
                if (current.right != null) q.offer(current.right);

                prev = current;
            }

        }

        return root;
    }

    public Node connect(Node root) {

        if (null == root) return null;

        Node current = root;

        while (null != current) {

            Node dummy = new Node(0);
            Node tail = dummy;

            while (null != current) {

                if (null != current.left) {
                    tail.next = current.left;
                    tail = tail.next;
                }

                if (null != current.right) {
                    tail.next = current.right;
                    tail = tail.next;
                }

                current = current.next;
            }

            current = dummy.next;
        }
        return root;
    }

    public Node connectRecursive(Node root) {
        if (null == root) return root;

        Node nextNode = getNextNode(root.next);

        if (null != root.right) {
            root.right.next = nextNode;
        }

        if (null != root.left) {
            root.left.next = root.right != null ? root.right : nextNode;
        }


        connectRecursive(root.right);
        connectRecursive(root.left);

        return root;
    }

    public Node getNextNode(Node node) {
        if (null != node) {
            if (node.right != null) return node.right;
            if (node.left != null) return node.left;
            node = node.next;
        }

        return null;
    }

    private static void printLevels(Node root) {
        Node levelStart = root;

        while (levelStart != null) {
            Node curr = levelStart;
            levelStart = null;

            while (curr != null) {
                System.out.print(curr.val + " -> ");

                if (levelStart == null) {
                    if (curr.left != null) levelStart = curr.left;
                    else if (curr.right != null) levelStart = curr.right;
                }
                curr = curr.next;
            }
            System.out.println("NULL");
        }
    }

}


class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}
