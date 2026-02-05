package com.leetcode.linkedlist;

/**
 * Given the head of a linked list, rotate the list to the right by k places.
 */
public class RotateList {

    public static void main(String[] args) {
        RotateList rotateList = new RotateList();
        int[] values = {1, 2, 3, 4, 5};
        int k = 2;

        // Create linked list
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }

        System.out.print("Original List: ");
        printList(head);

        // Rotate list
        head = rotateList.rotateRight(head, k);

        System.out.print("Rotated List:  ");
        printList(head);
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        int length = 1;
        ListNode cur = head;

        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        cur.next = head;

        k = k % length;

        int stepToNewHead = length - k;

        for (int i = 1; i < stepToNewHead; i++) {
            head = head.next;
        }

        ListNode newHead = head.next;
        head.next = null;

        return newHead;

    }

    private static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
}
