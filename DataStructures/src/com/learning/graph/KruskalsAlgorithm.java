package com.learning.graph;


import java.util.ArrayList;
import java.util.Collections;

public class KruskalsAlgorithm {

    static int parent[], rank[];

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

    int spanningTreeCost(int vertex, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean added[][] = new boolean[vertex][vertex];
        ArrayList<Edge> edges = new ArrayList<>();
        //converting the arraylist of adjacency list to list of edges
        //[
        // [[1, 5], [2, 1]],
        // [[0, 5], [2, 3]],
        // [[1, 3], [0, 1]]
        // ]
        for (int i = 0; i < adj.size(); i++) {
            //Got to internal list -> [[1, 5], [2, 1]]
            for (int j = 0; j < adj.get(i).size(); j++) {
                //vertex + weight list -> [1, 5]
                //[1, 5]
                ArrayList<Integer> current = adj.get(i).get(j);

                if(!added[i][current.get(0)]){
                    added[i][current.get(0)] = true;
                    added[current.get(0)][i] = true;
                    //Source(j) (current vertex)
                    // -> dest(destination vertex)
                    // -> weight (destination's vertex's weight)
                    //src, dest, weight;
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
        int mstCost = 0;

        for (int i = 0; count < vertex; i++) {
            Edge edge = edges.get(i);

            int rootX = find(edge.src);
            int rootY = find(edge.dest);

            //Deciding logic to add that edge to the disjoint set.
            if (rootX != rootY) {
                union(rootX, rootY);
                count++;
                mstCost += edge.weight;
            }
        }

        return mstCost;
    }

    static class Edge implements Comparable<Edge> {
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
