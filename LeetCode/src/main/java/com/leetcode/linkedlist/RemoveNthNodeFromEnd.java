package com.leetcode.linkedlist;

public class RemoveNthNodeFromEnd {

    public static void main(String[] args) {

        RemoveNthNodeFromEnd removeNthNodeFromEnd = new RemoveNthNodeFromEnd();

        // Input: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int n = 2;

        System.out.print("Original: ");
        System.out.println(head);

        head = removeNthNodeFromEnd.removeNthFromEnd(head, n);

        System.out.print("After Removal: ");
        System.out.println(head);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (null == head) return null;

        ListNode fast = head;

        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        if (fast == null) return head.next;

        ListNode slow = head;

        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        ListNode next = slow.next;
        slow.next = next.next;
        next.next = null;

        return head;
    }
}
