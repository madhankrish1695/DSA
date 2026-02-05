package com.leetcode.linkedlist;


/**
 * Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * <p>
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {

    public static void main(String[] args) {

        PartitionList partitionList = new PartitionList();
        // 🔹 Test Input
        int[] values = {1, 4, 3, 2, 5, 2};
        int x = 3;

        // Build linked list
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
        }

        System.out.println("Original List: " + head);

        head = partitionList.partition(head, x);

        System.out.println("Partitioned List: " + head);

    }

    public ListNode partition(ListNode head, int x) {
        ListNode beforeHead = new ListNode(0);
        ListNode afterHead = new ListNode(0);

        ListNode before = beforeHead;
        ListNode after = afterHead;

        ListNode current = head;

        while (current != null) {
            if (current.val < x) {
                before.next = current;
                before = before.next;
            } else {
                after.next = current;
                after = after.next;
            }
            current = current.next;

        }
        after.next = null;
        before.next = afterHead.next;

        return beforeHead.next;
    }
}
