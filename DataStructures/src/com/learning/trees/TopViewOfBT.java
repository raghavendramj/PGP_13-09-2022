package com.learning.trees;


import java.util.*;

class Pair {
    int hd;
    Node node;

    public Pair(int hd, Node node) {
        this.node = node;
        this.hd = hd;
    }
}


public class TopViewOfBT {

    Node root;

    static List<Integer> topView(Node root) {
        Queue<Pair> pairQueue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        pairQueue.add(new Pair(0, root));
        while (!pairQueue.isEmpty()) {
            Pair current = pairQueue.poll();
            //System.out.print(current.node.data+"   ");

            //First occurrence of HD in the tree
            if (!map.containsKey(current.hd)) {
                map.put(current.hd, current.node.data);
            }

            if (current.node.left != null) {
                pairQueue.add(new Pair(current.hd - 1, current.node.left));
            }

            if (current.node.right != null) {
                pairQueue.add(new Pair(current.hd + 1, current.node.right));
            }
        }
        return new ArrayList<>(map.values());
    }

    static List<Integer> bottomView(Node root) {
        Queue<Pair> pairQueue = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>();

        pairQueue.add(new Pair(0, root));
        while (!pairQueue.isEmpty()) {
            Pair current = pairQueue.poll();

            //Last occurrence of HD in the tree
            map.put(current.hd, current.node.data);

            if (current.node.left != null) {
                pairQueue.add(new Pair(current.hd - 1, current.node.left));
            }

            if (current.node.right != null) {
                pairQueue.add(new Pair(current.hd + 1, current.node.right));
            }
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {

        TopViewOfBT tree = new TopViewOfBT();
        tree.root = new Node(7);
        tree.root.left = new Node(6);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(1);
        tree.root.left.right.left = new Node(4);

        tree.root.right = new Node(2);
        tree.root.right.left = new Node(8);
        tree.root.right.right = new Node(3);

        System.out.println("Top View for BT is :- " + topView(tree.root));
        System.out.println("Bottom View for BT is :- " + bottomView(tree.root));

    }
}
