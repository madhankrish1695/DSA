package com.leetcode.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {

    public static void main(String[] args) {
        // Creating sample graph:
        // 1 -- 2
        // |    |
        // 4 -- 3

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);

        node1.neighbors.add(node2);
        node1.neighbors.add(node4);

        node2.neighbors.add(node1);
        node2.neighbors.add(node3);

        node3.neighbors.add(node2);
        node3.neighbors.add(node4);

        node4.neighbors.add(node1);
        node4.neighbors.add(node3);

        CloneGraph solution = new CloneGraph();
        Node clonedGraph = solution.cloneGraph(node1);

        System.out.println("Cloned node value: " + clonedGraph.val);
        System.out.println("Neighbors of cloned node:");
        for (Node neighbor : clonedGraph.neighbors) {
            System.out.println(neighbor.val);
        }
    }

    public Node cloneGraph(Node node) {
        Map<Node, Node> cloneMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        cloneMap.put(node, new Node(node.val));
        while (!q.isEmpty()) {
            Node current = q.poll();
            for (Node neighbor : current.neighbors) {
                if (!cloneMap.containsKey(neighbor)) {
                    q.offer(neighbor);
                    cloneMap.put(neighbor, new Node(neighbor.val));
                }
                cloneMap.get(current).neighbors.add(cloneMap.get(neighbor));
            }
        }
        return cloneMap.get(node);
    }

    public Node cloneGraphDFS(Node node) {
        if (node == null) return null;

        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {

        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(dfs(neighbor, map));
        }

        return clone;
    }
}
