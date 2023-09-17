package com.learning.trees;

public class CheckIfBtIsBSTJava {


    Node root;

    public static void main(String[] args) {

        CheckIfBtIsBSTJava tree = new CheckIfBtIsBSTJava();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(5);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);

        // Function call
        if (tree.isValidBST(tree.root))
            System.out.println("IS BST");
        else
            System.out.println("Not a BST");
    }

    private boolean checkBST(Node node, long min, long max) {
        if (node == null)
            return true;
        if (node.data <= min || node.data >= max)
            return false;

        if (checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max)) {
            return true;
        }
        return false;
    }

    public boolean isValidBST(Node root) {
        return checkBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
}
