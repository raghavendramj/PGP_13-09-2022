package com.learning.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ZigZagTraversal {

    Node rootNode;

    public static void main(String[] args) {

        ZigZagTraversal tree = new ZigZagTraversal();
        tree.rootNode = new Node(1);
        tree.rootNode.left = new Node(2);
        tree.rootNode.right = new Node(3);
        tree.rootNode.left.left = new Node(7);
        tree.rootNode.left.right = new Node(6);
        tree.rootNode.right.left = new Node(5);
        tree.rootNode.right.right = new Node(4);

        System.out.println("ZigZag Order traversal of binary tree is");
        tree.printZigZagTraversal();

        System.out.println("\n\nzigzagLevelOrder :- "+ zigzagLevelOrder(tree.rootNode));
    }

    public static ArrayList<ArrayList<Integer>> zigzagLevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<Node>();
        ArrayList<ArrayList<Integer>> wrapList = new ArrayList<>();

        if (root == null)
            return wrapList;
        queue.offer(root);
        boolean flag = true;

        while (!queue.isEmpty()) {
            int levelNum = queue.size();

            ArrayList<Integer> subList = new ArrayList<Integer>(levelNum);
            for (int i = 0; i < levelNum; i++) {

                if (queue.peek().left != null)
                    queue.offer(queue.peek().left);
                if (queue.peek().right != null)
                    queue.offer(queue.peek().right);
                if (flag == true)
                    subList.add(queue.poll().data);
                else
                    subList.add(0, queue.poll().data);
            }
            flag = !flag;
            wrapList.add(subList);
        }
        return wrapList;
    }

    void printZigZagTraversal() {

        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<Node> currentLevel = new Stack<>();
        Stack<Node> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            Node node = currentLevel.pop();

            // print the data in it
            System.out.print(node.data + " ");

            // store data according to current
            // order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<Node> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }

}
