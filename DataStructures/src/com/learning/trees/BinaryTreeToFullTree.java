package com.learning.trees;

public class BinaryTreeToFullTree {

    Node root;

    public static void main(String args[]) {
        BinaryTreeToFullTree tree = new BinaryTreeToFullTree();
        Node NewRoot = null;
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        System.out.println("the inorder traversal of tree is ");
        tree.printInorder(tree.root);

        NewRoot = tree.RemoveHalfNodes(tree.root);

        System.out.print("\nInorder traversal of the modified tree \n");
        tree.printInorder(NewRoot);
    }

    void printInorder(Node node) {
        if (node != null) {
            printInorder(node.left);
            System.out.print(node.data + " ");
            printInorder(node.right);
        }
    }

    Node RemoveHalfNodes(Node node) {
        if (node == null)
            return null;

        node.left = RemoveHalfNodes(node.left);
        node.right = RemoveHalfNodes(node.right);

        /* if current node is a leaf node then return it without modifying it */
        if (node.left == null && node.right == null)
            return node;

        /* if current nodes is a half node with left
         child NULL left, then it's right child is
         returned and replaces it in the given tree */
        if (node.left == null) {
            Node new_root = node.right;
            return new_root;
        }

        /* if current nodes is a half node with right
           child NULL right, then it's left child is
           returned and replaces it in the given tree  */
        if (node.right == null) {
            Node new_root = node.left;
            return new_root;
        }
        return node;
    }

    void removeNode(Node root) {
        if (root == null) return;

        removeNode(root.left);
        removeNode(root.right);

        if (root.left == null && root.right != null) {
            root.data = root.right.data;
            root.right = null;
        } else if (root.right == null && root.left != null) {
            root.data = root.left.data;
            root.left = null;
        }
    }
}
