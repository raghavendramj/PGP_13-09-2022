package com.learning.trees;

import java.util.LinkedHashSet;
import java.util.Set;

public class BoundaryTraversal {
    Node root;

    Set<Integer> boundarySet = new LinkedHashSet<>();

    public static void main(String[] args) {
        BoundaryTraversal tree = new BoundaryTraversal();
        tree.root = new Node(20);
        tree.root.left = new Node(8);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(12);
        tree.root.left.right.left = new Node(10);
        tree.root.left.right.right = new Node(14);
        tree.root.right = new Node(22);
        tree.root.right.right = new Node(25);
        tree.printBoundary(tree.root);

        System.out.println(tree.boundarySet);
    }

    private void printBoundary(Node node) {

        if (node == null)
            return;

        //Print the root.
        //System.out.print(node.data + "  ");
        boundarySet.add(node.data);

        //1. Print Left boundary
        printLeftBoundary(node.left);

        //2. Print All the Leaves
        printLeaves(node.left);
        printLeaves(node.right);

        //3. Print Right Boundary
        printRightBoundary(node.right);

    }

    private void printRightBoundary(Node node) {
        if (node == null)
            return;

        if (node.right != null) {
            printRightBoundary(node.right);
            boundarySet.add(node.data);

        } else if (node.left != null) {
            printRightBoundary(node.left);
            boundarySet.add(node.data);
        }
    }

    private void printLeaves(Node node) {
        if (node == null)
            return;

        printLeaves(node.left);

        if (node.left == null && node.right == null)
            boundarySet.add(node.data);

        printLeaves(node.right);
    }

    private void printLeftBoundary(Node node) {
        if (node == null)
            return;

        if (node.left != null) {
            boundarySet.add(node.data);
            printLeftBoundary(node.left);
        } else if (node.right != null) {
            boundarySet.add(node.data);
            printLeftBoundary(node.right);
        }
    }
}
