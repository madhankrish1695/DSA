package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;


/**
 * A linked list of length n is given such that each node contains an additional random pointer, which could point to any node in the list, or null.
 * <p>
 * Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes, where each new node has its value set to the value of its corresponding original node. Both the next and random pointer of the new nodes should point to new nodes in the copied list such that the pointers in the original list and copied list represent the same list state. None of the pointers in the new list should point to nodes in the original list.
 * <p>
 * For example, if there are two nodes X and Y in the original list, where X.random --> Y, then for the corresponding two nodes x and y in the copied list, x.random --> y.
 * <p>
 * Return the head of the copied linked list.
 * <p>
 * The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val, random_index] where:
 * <p>
 * val: an integer representing Node.val
 * random_index: the index of the node (range from 0 to n-1) that the random pointer points to, or null if it does not point to any node.
 * Your code will only be given the head of the original linked list.
 */
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Node n1 = new Node(7);
        Node n2 = new Node(13);
        Node n3 = new Node(11);
        Node n4 = new Node(10);
        Node n5 = new Node(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;

        n1.random = null;
        n2.random = n1;
        n3.random = n5;
        n4.random = n3;
        n5.random = n1;

        CopyListWithRandomPointer copyListWithRandomPointer = new CopyListWithRandomPointer();

        System.out.println("Original List: ");
        printList(n1);

        System.out.println("\nCopied List:");

        printList(copyListWithRandomPointer.copyRandomList(n1));
    }

    public Node copyRandomList(Node head) {

        if (null == head) return null;

        Map<Node, Node> cloneMap = new HashMap<>();

        Node current = head;

        while (null != current) {
            cloneMap.put(current, new Node(current.val));
            current = current.next;
        }

        current = head;

        while (null != current) {
            Node clone = cloneMap.get(current);
            clone.next = cloneMap.get(current.next);
            clone.random = cloneMap.get(current.random);
            current = current.next;
        }

        return cloneMap.get(head);
    }

    private static void printList(Node head) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            System.out.print(
                    "Node " + index +
                            " [val=" + temp.val +
                            ", random=" + (temp.random != null ? temp.random.val : "null") +
                            "]"
            );
            System.out.println();
            temp = temp.next;
            index++;
        }
    }
}


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
