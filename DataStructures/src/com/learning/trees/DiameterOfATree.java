package com.learning.trees;

public class DiameterOfATree {

    Node root;
    int diameter = 0;

    public static void main(String[] args) {

        DiameterOfATree binaryTree = new DiameterOfATree();

        binaryTree.root = new Node(1);
        binaryTree.root.left = new Node(2);
        binaryTree.root.right = new Node(3);
        binaryTree.root.left.left = new Node(4);
        binaryTree.root.left.right = new Node(5);

        binaryTree.diameter(binaryTree.root);
        System.out.println("Height of tree is : " + binaryTree.diameter(binaryTree.root));
        System.out.println("Diameter of tree is : " + binaryTree.diameter);
    }

    private int diameter(Node root) {
        if (root == null)
            return 0;
        int leftHeight = diameter(root.left);
        int rightHeight = diameter(root.right);
        diameter = Math.max(diameter, (1 + leftHeight + rightHeight));
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
