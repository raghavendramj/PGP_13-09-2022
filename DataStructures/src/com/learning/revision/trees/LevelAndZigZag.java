package com.learning.revision.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelAndZigZag {

    Node rootNode;

    public static void main(String[] args) {
        LevelAndZigZag tree = new LevelAndZigZag();
        tree.rootNode = new Node(1);
        tree.rootNode.left = new Node(2);
        tree.rootNode.right = new Node(3);
        tree.rootNode.left.left = new Node(7);
        tree.rootNode.left.right = new Node(6);
        tree.rootNode.right.left = new Node(5);
        tree.rootNode.right.right = new Node(4);

        tree.levelOrderTraversal(tree.rootNode);
        tree.zigZagOrderTraversal(tree.rootNode);
    }


    static void levelOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> traversalQueue = new LinkedList<>();
        traversalQueue.add(root);

        ArrayList<ArrayList<Integer>> wrappedList = new ArrayList<>();
        while (!traversalQueue.isEmpty()) {
            int level = traversalQueue.size();
            ArrayList<Integer> eachLevelList = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                Node currentNode = traversalQueue.poll();
                if (currentNode.left != null) {
                    traversalQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    traversalQueue.offer(currentNode.right);
                }
                eachLevelList.add(currentNode.data);
            }
            wrappedList.add(eachLevelList);
        }
        System.out.println("Level order traversal is :- " + wrappedList);
    }

    static void zigZagOrderTraversal(Node root) {
        if (root == null)
            return;
        Queue<Node> traversalQueue = new LinkedList<>();
        traversalQueue.add(root);

        ArrayList<ArrayList<Integer>> wrappedList = new ArrayList<>();
        boolean flag = true;
        while (!traversalQueue.isEmpty()) {
            int level = traversalQueue.size();
            ArrayList<Integer> eachLevelList = new ArrayList<>();

            for (int i = 0; i < level; i++) {
                Node currentNode = traversalQueue.poll();
                if (currentNode.left != null) {
                    traversalQueue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    traversalQueue.offer(currentNode.right);
                }
                if (flag) {
                    eachLevelList.add(currentNode.data);
                } else {
                    eachLevelList.add(0, currentNode.data);
                }
            }
            flag = !flag;
            wrappedList.add(eachLevelList);
        }
        System.out.println("ZigZag order traversal is :- " + wrappedList);
    }


}
