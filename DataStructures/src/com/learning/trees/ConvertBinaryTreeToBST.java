package com.learning.trees;

import java.util.Arrays;

public class ConvertBinaryTreeToBST {

    Node root;

    public static void main(String[] args) {
        ConvertBinaryTreeToBST tree = new ConvertBinaryTreeToBST();
        tree.root = new Node(10);
        tree.root.left = new Node(2);
        tree.root.right = new Node(7);
        tree.root.left.left = new Node(8);
        tree.root.left.right = new Node(4);

        System.out.print("\nBefore In order :- ");
        tree.inOrder(tree.root);
        System.out.println();

        tree.changeBTtoBST(tree.root, tree.countBTNodes(tree.root));

        System.out.print("\nAfter In order :- ");
        tree.inOrder(tree.root);

    }

    void inOrder(Node node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print("  " + node.data);
        inOrder(node.right);
    }

    private int countBTNodes(Node root) {
        if (root == null)
            return 0;
        return countBTNodes(root.left) + 1 + countBTNodes(root.right); //left + root + right (Nodes);
    }

    public void changeBTtoBST(Node root, int treeSize) {
        int inorder[] = new int[treeSize];
        int index[] = new int[1];
        createInOrderArray(root, inorder, index);
        Arrays.sort(inorder);

        index = new int[1];
        changeNodeValues(root, inorder, index);
    }

    private void createInOrderArray(Node root, int[] inorder, int[] index) {
        if (root == null)
            return;

        createInOrderArray(root.left, inorder, index);
        inorder[index[0]] = root.data;
        index[0] += 1;
        createInOrderArray(root.right, inorder, index);
    }

    private void changeNodeValues(Node root, int[] inorder, int[] index) {
        if (root == null)
            return;

        changeNodeValues(root.left, inorder, index);
        root.data = inorder[index[0]];
        index[0] += 1;

        changeNodeValues(root.right, inorder, index);

    }

}
