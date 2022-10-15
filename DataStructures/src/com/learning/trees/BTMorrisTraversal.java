package com.learning.trees;

import java.util.ArrayList;
import java.util.List;

public class BTMorrisTraversal {

//    In-order Morris Traversal:
//    🌳 1st case: if left is null, print current node and go right
//    🌳 2nd case: before going left, make right most node on left subtree connected to current node, then go left
//    🌳 3rd case: if thread is already pointed to current node, then remove the thread

    Node root;

    public static void main(String[] args) {
        BTMorrisTraversal tree = new BTMorrisTraversal();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.left.right.right = new Node(6);

        List<Integer> oldInOrder = new ArrayList<>();
        tree.inOrder(tree.root, oldInOrder);
        System.out.println("Recursive In-order is :- " + oldInOrder);

        List<Integer> inorderList = tree.morrisInorder(tree.root);
        System.out.println("Iterative Morris In-order is :- " + inorderList);
    }

    public void inOrder(Node root, List<Integer> integerList) {
        if (root == null)
            return;

        inOrder(root.left, integerList);
        integerList.add(root.data);
        inOrder(root.right, integerList);
    }

    public List<Integer> morrisInorder(Node root) {
        List<Integer> inorder = new ArrayList<>();
        Node cur = root;

        while (cur != null) {
            //1st case: if left is null, print current node and go right
            if (cur.left == null) {
                inorder.add(cur.data);
                cur = cur.right;
            } else {
                //2nd case: before going left, make right most node on left subtree connected to current node, then go left
                Node prev = cur.left;
                while (prev.right != null && prev.right != cur) {
                    prev = prev.right;
                }
                if (prev.right == null) {
                    prev.right = cur;
                    cur = cur.left;
                } else {
                    //3rd case: if thread is already pointed to current node, then remove the thread
                    prev.right = null;
                    inorder.add(cur.data);
                    cur = cur.right;
                }
            }
        }
        return inorder;
    }
}
