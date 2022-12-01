package com.learning.assignments;

import java.util.ArrayList;
import java.util.Collections;

public class KruskalAlgorithm {

    static int parent[], rank[];

    static int find(int x) {
        if (parent[x] == x)
            return x;
        return find(parent[x]);
    }

    static void union(int x, int y) {
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

    public static void main(String[] args) {
	//adj -> [[[1, 5], [2, 1]], [[0, 5], [2, 3]], [[1, 3], [0, 1]]]
    }

    int spanningTreeCost(int vertex, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        boolean added[][] = new boolean[vertex][vertex];
        ArrayList<Edge> edges = new ArrayList<>();

        for (int i = 0; i < adj.size(); i++) {
            for (int j = 0; j < adj.get(i).size(); j++) {
                ArrayList<Integer> current = adj.get(i).get(j);
                if (!added[i][current.get(0)]) {
                    added[i][current.get(0)] = true;
                    added[current.get(0)][i] = true;
                    edges.add(new Edge(i, current.get(0), current.get(1)));
                }
            }
        }
		rank = new int[vertex];
        parent = new int[vertex];
        for (int i = 0; i < vertex; i++) {
            parent[i] = i;
        }

        Collections.sort(edges);
        int count = 1;

        int countMST = 0;
        for (int i = 0; count < vertex; i++) {
            Edge edge = edges.get(i);
            int rootX = find(edge.src);
            int rootY = find(edge.dest);

            if (rootX != rootY) {
                union(rootX, rootY);
                count++;
                countMST += edge.weight;
            }
        }

        return countMST;
    }

    class Edge implements Comparable<Edge> {

        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge that) {
            return this.weight - that.weight;
        }
    }
}
