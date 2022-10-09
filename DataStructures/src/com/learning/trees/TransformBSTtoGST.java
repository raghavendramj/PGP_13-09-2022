package com.learning.trees;

public class TransformBSTtoGST {

    //https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
    private int sum;

    public Node bstToGst(Node root) {
        convertToGreaterSumTree(root);
        return root;
    }

    private void convertToGreaterSumTree(Node root) {

        if (root == null)
            return;

        convertToGreaterSumTree(root.right);
        root.data += sum;
        sum = root.data;
        convertToGreaterSumTree(root.left);
    }
}
