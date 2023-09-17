package com.learning.revision.graphs;

import com.learning.graph.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    //adj [] = {{{1, 9}}, {{0, 9}}}
    static int[] dijkstra(int src, int noOfVertices, ArrayList<ArrayList<ArrayList<Integer>>> adj) {
        boolean visited[] = new boolean[noOfVertices];

        PriorityQueue<Pair> minCostQueue = new PriorityQueue<>();
        minCostQueue.add(new Pair(src, 0));


        int answer[] = new int[noOfVertices];
        Arrays.fill(answer, Integer.MAX_VALUE);
        answer[src] = 0;

        while (!minCostQueue.isEmpty()) {
            Pair curPair = minCostQueue.remove();
            int currVertex = curPair.vertex;

            if (visited[currVertex])
                continue;

            visited[currVertex] = true;
            ArrayList<ArrayList<Integer>> neighbors = adj.get(currVertex);
            for (ArrayList<Integer> eachNeighor : neighbors) {
                int eachNeigbourVertex = eachNeighor.get(0);
                int eachNeigboutWeight = eachNeighor.get(1);

                int newWeight = answer[currVertex] + eachNeigboutWeight;

                if (answer[eachNeigbourVertex] > newWeight) {
                    answer[eachNeigbourVertex] = newWeight;
                }
            }
        }
        return answer;
    }
}
