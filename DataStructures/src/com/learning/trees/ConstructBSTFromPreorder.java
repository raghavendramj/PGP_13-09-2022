package com.learning.trees;

public class ConstructBSTFromPreorder {

    private static int index;
    private static int preorder[];
    Node root;

    void inOrder(Node node) {

        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print("  " + node.data);
        inOrder(node.right);
    }

    public static void main(String[] args) {
        ConstructBSTFromPreorder tree = new ConstructBSTFromPreorder();
        int preorder[] = {8, 5, 1, 7, 10, 12};
        tree.root = tree.bstFromPreorder(preorder);

        System.out.print("\nAfter In order :- ");
        tree.inOrder(tree.root);
    }

    public Node bstFromPreorder(int[] preorder) {
        this.index = 0;
        this.preorder = preorder;

        return BuildTree(Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public Node BuildTree(int min, int max) {
        if (index == preorder.length || preorder[index] < min || preorder[index] > max)
            return null;
        Node root = new Node(preorder[index]);
        index++;

        root.left = BuildTree(min, root.data);
        root.right = BuildTree(root.data, max);

        return root;
    }
}
