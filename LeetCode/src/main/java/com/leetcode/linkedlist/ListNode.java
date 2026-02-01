package com.leetcode.linkedlist;

public class ListNode {

    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    @Override
    public String toString() {
        ListNode current = next;
        StringBuilder sb = new StringBuilder("")
                .append(this.val)
                .append(" -> ");
        while (current != null) {
            sb.append(current.val).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }
}
