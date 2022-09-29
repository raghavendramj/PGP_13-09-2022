package com.learning.trees;

public class Node {

    public Node left;
    public Node right;
    public int data;

    public Node(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}
