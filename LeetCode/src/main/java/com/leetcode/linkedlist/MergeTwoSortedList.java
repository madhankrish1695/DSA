package com.leetcode.linkedlist;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 */
public class MergeTwoSortedList {

    public static void main(String[] args) {
        // list1 = 1 -> 2 -> 4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);

        // list2 = 1 -> 3 -> 4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);

        MergeTwoSortedList mergeTwoSortedList = new MergeTwoSortedList();
        System.out.println(mergeTwoSortedList.mergeTwoLists(list1, list2));
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (null == l1) return l2;
        if (null == l2) return l1;

        ListNode dummy = new ListNode();

        ListNode current = dummy;
        while (null != l1 && null != l2) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if (null != l1) {
            current.next = l1;
        }

        if (null != l2) {
            current.next = l2;
        }

        return dummy.next;
    }
}
