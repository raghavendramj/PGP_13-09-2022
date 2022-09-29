package com.learning.trees;

public class AreTreesIdentical {

    public static void main(String[] args) {

        AreTreesIdentical object = new AreTreesIdentical();

        Node tree1 = new Node(1);
        tree1.left = new Node(2);
        tree1.right = new Node(3);
        tree1.left.left = new Node(4);
        tree1.left.right = new Node(5);


        Node tree2 = new Node(1);
        tree2.left = new Node(2);
        tree2.right = new Node(3);
        tree2.left.left = new Node(4);
        tree2.left.right = new Node(5);


        System.out.println("Are trees identical? : " +
                object.isSameTree(tree1, tree2));
    }

    public boolean isSameTree(Node p, Node q) {
        if (p == null || q == null)
            return p == q;
        return p.data == q.data && isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right);
    }
}
