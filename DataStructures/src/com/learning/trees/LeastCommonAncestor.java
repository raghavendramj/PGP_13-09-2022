package com.learning.trees;

public class LeastCommonAncestor {

    static Node lca(Node root, int n1, int n2) {
        if (root == null)
            return null;

        //n1 or n2 is root
        if (root.data == n1 || root.data == n2)
            return root;

        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        //Both a and b in right subtree
        if (left == null)
            return right;

        //Both a and b in left subtree
        if (right == null)
            return left;

        //a -> left subtree, b-> right subtree
        return root;
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.right.left = new Node(6);
        node.right.right = new Node(7);
        System.out.println("lca(2, 4) is " + lca(node, 2, 4).data);
        System.out.println("lca(2, 7) is " + lca(node, 2, 7).data);
    }
}




