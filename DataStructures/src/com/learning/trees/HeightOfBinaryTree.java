package com.learning.trees;


public class HeightOfBinaryTree {

    Node root;

    public static void main(String[] args) {

        HeightOfBinaryTree binaryTree = new HeightOfBinaryTree();

        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);

        System.out.println("Height of tree is : " +
                binaryTree.maxDepth(binaryTree.root));
    }

    private int maxDepth(Node node) {
        if (node == null)
            return 0;
        else {
            int lDepth = maxDepth(node.left);
            int rDepth = maxDepth(node.right);
            return Math.max(lDepth, rDepth) + 1;
        }
    }
}
