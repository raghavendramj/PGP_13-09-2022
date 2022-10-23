package com.learning.heaps;

import java.util.LinkedList;
import java.util.Queue;

public class IsBinayTreeAHeap {

    Node root;

    static boolean isCompleteBinaryTree(Node tree) {
        Queue<Node> nodeQueue = new LinkedList<>();
        nodeQueue.add(tree);
        boolean flag = false;
        while (!nodeQueue.isEmpty()) {
            Node curNode = nodeQueue.poll();
            if (curNode == null) {
                flag = true;
            } else {
                if (flag) {
                    return false;
                }
                nodeQueue.add(curNode.left);
                nodeQueue.add(curNode.right);
            }
        }
        return true;
    }

    static boolean isHeap(Node node) {
        if (node == null) {
            return true;
        }

        if (node.left != null && node.left.data > node.data) {
            return false;
        }

        if (node.right != null && node.right.data > node.data) {
            return false;
        }

        return isHeap(node.left) && isHeap(node.right);
    }

    public static void main(String[] args) {
        IsBinayTreeAHeap tree = new IsBinayTreeAHeap();

//        Node root = new Node(10);
//        root.left = new Node(9);
//        root.right = new Node(8);
//        root.left.left = new Node(17);
//        root.left.right = new Node(6);
//        root.right.left = new Node(5);
//        root.right.right = new Node(4);
//        root.left.left.left = new Node(3);
//        root.left.left.right = new Node(2);
//        root.left.right.left = new Node(1);

        Node root = new Node(51);
        root.left = new Node(48);
        root.right = new Node(35);

        root.left.left = new Node(22);
        root.left.right = new Node(25);

        root.right.left = new Node(20);
        root.right.right = new Node(30);

        boolean isBTaHeap = tree.isGivenBTisAHeap(root);

        if (isBTaHeap)
            System.out.println(
                    "Given binary tree is a Heap");
        else
            System.out.println(
                    "Given binary tree is not a Heap");
    }

    boolean isGivenBTisAHeap(Node node) {
        return isCompleteBinaryTree(node) && isHeap(node);
    }
}
