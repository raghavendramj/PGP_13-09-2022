package com.learning.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {

    public static void main(String[] args) {

        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);

        printLevelOrder(node);

    }

    private static void printLevelOrder(Node node) {

        if (node == null)
            return;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);
        while (!nodeQueue.isEmpty()) {
            Node tempNode = nodeQueue.poll(); //remove an element from the queue.

            System.out.print(tempNode.data + " -> ");

            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
            }
        }
    }

    private List<List<Integer>> levelOrderTraversalLC(Node node) {
        List<List<Integer>> levels = new ArrayList<>();

        if (node == null)
            return levels;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(node);
        nodeQueue.add(new Node(Integer.MAX_VALUE)); //dummy node added



        List<Integer> eachLevelList = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {
            Node tempNode = nodeQueue.poll(); //remove an element from the queue.


            if (tempNode.data == Integer.MAX_VALUE) {
                levels.add(eachLevelList);
                eachLevelList = new ArrayList<>();

                if (nodeQueue.isEmpty()) {
                    System.out.println(levels);
                    return levels;
                } else {
                    nodeQueue.add(new Node(Integer.MAX_VALUE));
                }

            } else {
                System.out.print(tempNode.data + " -> ");
                eachLevelList.add(tempNode.data);
            }


            if (tempNode.left != null) {
                nodeQueue.add(tempNode.left);
            }
            if (tempNode.right != null) {
                nodeQueue.add(tempNode.right);
            }
        }

        return levels;
    }
}
