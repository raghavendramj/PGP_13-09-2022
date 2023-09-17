package com.learning.trees;

import java.util.*;

public class VerticalTraversal {

    Node root;

    public static void main(String[] args) {

        VerticalTraversal binaryTree = new VerticalTraversal();
        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);
        System.out.println("Vertical Order Traversal :- "+ verticalOrder(binaryTree.root));
    }


    static ArrayList<Integer> verticalOrder(Node root) {

        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        Queue<Pair> pairQueue = new LinkedList<>();
        pairQueue.add(new Pair(0, root));
        while (!pairQueue.isEmpty()) {

            Pair currentPair = pairQueue.poll();
            int horizontalDist = currentPair.hd;
            ArrayList<Integer> levelList = new ArrayList<>();
            if (map.containsKey(horizontalDist)) {
                levelList = map.get(horizontalDist);
            }
            levelList.add(currentPair.node.data);
            map.put(horizontalDist, levelList);

            if (currentPair.node.left != null) {
                pairQueue.add(new Pair(currentPair.hd - 1, currentPair.node.left));
            }

            if (currentPair.node.right != null) {
                pairQueue.add(new Pair(currentPair.hd + 1, currentPair.node.right));
            }
        }
        ArrayList<Integer> answer = new ArrayList<>();
        for (Map.Entry<Integer, ArrayList<Integer>> entry : map.entrySet())
            answer.addAll(entry.getValue());

        return answer;

    }
}
