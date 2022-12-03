package com.learning.graph;

import java.util.ArrayList;
import java.util.PriorityQueue;




public class PrimsAlgorithm {

    public static void main(String[] args) {

        //Adjacency matrix of weights
        //      0 1 2
        //    -------
        //0:- | 0 1 5
        //1:- | 1 2 3
        //1:- | 0 2 1

        //[
        // 0 -> [[1, 5], [2, 1]],
        // 1 -> [[0, 5], [2, 3]],
        // 2 -> [[1, 3], [0, 1]]
        //
        // ]
    }

    int spanningTreeCost(int vertex, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean visited[] = new boolean[vertex];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(0, 0));
        int mstCost = 0;
        while (queue.size() != 0) {

            Pair curPair = queue.poll();
            int curVertex = curPair.vertex;

            if (visited[curVertex])
                continue;

            visited[curVertex] = true;
            mstCost += curPair.weight;

            ArrayList<ArrayList<Integer>> neighbours = adj.get(curVertex);

            for (ArrayList<Integer> eachNeighbour : neighbours) {

                //[
                // [[1, 5], [2, 1]],
                // [[0, 5], [2, 3]],
                // [[1, 3], [0, 1]]
                // ]

                int eachNeighbourVertex = eachNeighbour.get(0); // Contains vertex
                int eachNeighbourWeight = eachNeighbour.get(1);  // Contains weight
                if (!visited[eachNeighbourVertex]) {
                    queue.add(new Pair(eachNeighbourVertex, eachNeighbourWeight));
                }
            }
        }
        return mstCost;
    }

}
