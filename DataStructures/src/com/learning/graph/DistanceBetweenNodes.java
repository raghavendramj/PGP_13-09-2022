package com.learning.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DistanceBetweenNodes {
    int noOfVertices;
    LinkedList<Integer> adj[];

    public DistanceBetweenNodes(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    boolean distanceBetweenNodes(int source, int dest, int pred[], int dist[]) {
        LinkedList<Integer> queue = new LinkedList<>();
        boolean visited[] = new boolean[noOfVertices + 1];
        for (int i = 0; i < noOfVertices; i++) {
            visited[i] = false;
            dist[i] = Integer.MAX_VALUE;
            pred[i] = -1;
        }
        visited[source] = true;
        dist[source] = 0;
        queue.add(source);

        ArrayList<Integer> bfsList = new ArrayList<>();
        while (queue.size() != 0) {
            int cur = queue.poll();
            bfsList.add(cur);

            for (Integer eachVertex : adj[cur]) {
                if (!visited[eachVertex]) {
                    queue.add(eachVertex);
                    visited[eachVertex] = true;

                    dist[eachVertex] = dist[cur] + 1;
                    pred[eachVertex] = cur;

                    if (eachVertex == dest)
                        return true;
                }
            }
        }
        return false;
    }
}
