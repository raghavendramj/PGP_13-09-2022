package com.learning.trees;

import java.util.Map;
import java.util.TreeMap;

public class VerticalSum {

    public static void printVerticalSum(Node root, int dist, Map<Integer, Integer> map) {
        if (root == null) {
            return;
        }
        map.put(dist, map.getOrDefault(dist, 0) + root.data);
        printVerticalSum(root.left, dist - 1, map);
        printVerticalSum(root.right, dist + 1, map);
    }

    public static void printVerticalSum(Node root) {
        Map<Integer, Integer> map = new TreeMap<>();
        printVerticalSum(root, 0, map);
        System.out.println(map.values());
    }

    public static void main(String[] args) {

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(5);
        root.right.right = new Node(6);
        root.right.left.left = new Node(7);
        root.right.left.right = new Node(8);
        printVerticalSum(root);
    }
}
