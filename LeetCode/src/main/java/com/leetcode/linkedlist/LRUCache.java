package com.leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 * <p>
 * Implement the LRUCache class:
 * <p>
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 */
public class LRUCache {

    int capacity = 0;
    LRUNode head = null;
    LRUNode tail = null;

    Map<Integer, LRUNode> nodeMap;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new LRUNode(-1, -1);
        tail = new LRUNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.nodeMap = new HashMap<>();
    }

    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;

        LRUNode node = nodeMap.get(key);

        removeNode(node);
        addToHead(node);

        return node.value;
    }

    public void put(int key, int value) {
        if (nodeMap.containsKey(key)) {
            LRUNode node = nodeMap.get(key);
            node.value = value;
            removeNode(node);
            addToHead(node);
        } else {

            if (nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                removeNode(tail.prev);
            }

            LRUNode node = new LRUNode(key, value);
            addToHead(node);
            nodeMap.put(key, node);
        }
    }

    private void removeNode(LRUNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToHead(LRUNode node) {
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);

        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1)); // 1

        cache.put(3, 3); // evicts key 2
        System.out.println(cache.get(2)); // -1

        cache.put(4, 4); // evicts key 1
        System.out.println(cache.get(1)); // -1
        System.out.println(cache.get(3)); // 3
        System.out.println(cache.get(4)); // 4
    }
}


class LRUNode {
    LRUNode prev;
    LRUNode next;
    int key;
    int value;

    public LRUNode(int key, int value) {
        this.key = key;
        this.value = value;
    }
}
