package com.learning.assignments;

public class DisjointUnionSets {

    int[] rank, parent;
    int n;

    public DisjointUnionSets(int n) {
        this.n = n;
        rank = new int[n];
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    int compressedFind(int x) {
        if (parent[x] != x) {
            return compressedFind(parent[x]);
        }

        return parent[x];
    }

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return find(parent[x]);
    }

    void union(int x, int y) {
        int xRoot = find(x);
        int yRoot = find(y);

        //If both the roots are same.
        if (xRoot == yRoot)
            return;

        //Assign larger ranked parent to other one.
        if (rank[xRoot] < rank[yRoot]) {
            parent[xRoot] = yRoot;
        } else if (rank[yRoot] < rank[xRoot]) {
            parent[yRoot] = xRoot;
        } else {
            parent[yRoot] = xRoot;
            rank[xRoot] = rank[xRoot] + 1;
        }
    }
}
