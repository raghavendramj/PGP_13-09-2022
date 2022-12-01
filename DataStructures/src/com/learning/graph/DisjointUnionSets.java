package com.learning.graph;

public class DisjointUnionSets {

    int parent[];
    int rank[];
    int noOfVertices;

    public DisjointUnionSets(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        rank = new int[noOfVertices];
        parent = new int[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            parent[i] = i;
        }
    }

    int find(int vertex) {
        if (parent[vertex] == vertex) {
            return vertex;
        }
        return find(parent[vertex]);
    }

    void union(int vertX, int vertY) {
        int xRoot = find(vertX);
        int yRoot = find(vertY);

        //if both the roots are same, means they are part of disjoint set already
        if (xRoot == yRoot)
            return;

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
