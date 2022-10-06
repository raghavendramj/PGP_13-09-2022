package com.learning.trees;

public class BST_Insert {

    Node root;

    public static void main(String[] args) {

        BST_Insert tree = new BST_Insert();
        int arr[] = {20, 8, 22, 12, 10, 4, 14};
        for (int eachNode : arr) {
            tree.root = tree.insertElement(tree.root, eachNode);
        }
        tree.inOrder(tree.root);
    }

    void inOrder(Node root) {
        if (root == null)
            return;
        inOrder(root.left);
        System.out.print(root.data + "   ");
        inOrder(root.right);
    }

    private Node insertElement(Node node, int newValue) {

        if (node == null) {
            node = new Node(newValue);
            return node;
        }
        if (newValue < node.data) {
            node.left = insertElement(node.left, newValue);
        } else if (newValue > node.data) {
            node.right = insertElement(node.right, newValue);
        }
        return node;
    }
}
