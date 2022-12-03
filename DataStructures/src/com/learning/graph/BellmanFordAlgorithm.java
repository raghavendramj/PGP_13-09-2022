package com.learning.graph;

import java.util.Arrays;

public class BellmanFordAlgorithm {

    int isNegativeWeightCycle(int n, int edges[][]) {
        int dist[] = new int[];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        //DP -> n-1 no of vertices
        for (int count = 1; count < n; count++) {
            for (int j = 0; j < edges.length; j++) {
                int source = edges[j][0]; //Source
                int dest = edges[j][1]; //Destination
                int weight = edges[j][2];
                if (dist[source] != Integer.MAX_VALUE && dist[source] + weight < dist[dest]) {
                    dist[dest] = dist[source] + weight;
                }
            }
        }
        for (int j = 0; j < edges.length; j++) {
            int source = edges[j][0]; //Source
            int dest = edges[j][1]; //Destination
            int weight = edges[j][2];
            if (dist[source] != Integer.MAX_VALUE && dist[source] + weight < dist[dest]) {
                //The value is getting changed -> Its a cycle
                return 1;
            }
        }
        return 0;
    }

}
