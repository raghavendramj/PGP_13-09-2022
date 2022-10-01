package com.learning.trees;

import java.util.*;

public class ZigZagClass {

    public static void zigZagTraversal(Node rootNode) {

        if (rootNode == null)
            return;

        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(rootNode);
        nodeQueue.add(new Node(-1));

        List<Integer> eachLevelList = new ArrayList<>();
        List<List<Integer>> allLevelsList = new ArrayList<>();
        while (!nodeQueue.isEmpty()) {

            Node currentNode = nodeQueue.poll();

            if (currentNode.data != -1) {
                //Other than -1, add its children to the queue and add current also to the current level list
                eachLevelList.add(currentNode.data);

                if (currentNode.left != null)
                    nodeQueue.add(currentNode.left);

                if (currentNode.right != null)
                    nodeQueue.add(currentNode.right);

            } else {

                // if -1, check whether do we have any other elements in the queue, if not return!
                allLevelsList.add(eachLevelList);
                eachLevelList = new ArrayList<>();

                if (nodeQueue.isEmpty()) {
                    System.out.println("Level Order Traversal; :- " + allLevelsList);
                    break;

                } else {
                    nodeQueue.add(new Node(-1));
                }
            }
        }

        boolean leftToRight = true;

        for (List<Integer> currLevelList : allLevelsList) {

            if (leftToRight) {
                System.out.println(currLevelList);
            } else {
                Collections.reverse(currLevelList);
                System.out.println(currLevelList);
            }
            leftToRight = !leftToRight;
        }
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        node.right.right.left = new Node(12);
        node.right.right.right = new Node(16);

        zigZagTraversal(node);
    }
}
