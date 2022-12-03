package com.learning.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    //Shortest path from current vertex to all the vertices in a graph.
    static int[] dijkstra(int source, int noOfVertices, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean visited[] = new boolean[noOfVertices];
        PriorityQueue<Pair> queue = new PriorityQueue<>();
        queue.add(new Pair(source, 0));

        int answer[] = new int[noOfVertices];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[source] = 0;

        while (queue.size() != 0) {
            Pair curPair = queue.remove();
            int curVertex = curPair.vertex;

            if (visited[curVertex])
                continue;

            visited[curVertex] = true;
            ArrayList<ArrayList<Integer>> neighbours = adj.get(curVertex);
            for (ArrayList<Integer> eachNeighbour : neighbours) {
                int eachNeighbourVertex = eachNeighbour.get(0); // Contains vertex
                int eachNeighbourWeight = eachNeighbour.get(1);  // Contains weight

                //If you get weight lesser than the current weight for the same vertex, then update it.
                if (answer[eachNeighbourVertex] > answer[curVertex] + eachNeighbourWeight) {
                    answer[eachNeighbourVertex] = answer[curVertex] + eachNeighbourWeight;
                    queue.add(new Pair(eachNeighbourVertex, answer[eachNeighbourVertex]));
                }
            }
        }
        return answer;
    }
}
