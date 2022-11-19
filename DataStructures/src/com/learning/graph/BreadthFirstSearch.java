package com.learning.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class BreadthFirstSearch {

    int noOfVertices;
    LinkedList<Integer> adj[];

    public BreadthFirstSearch(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        BreadthFirstSearch graph = new BreadthFirstSearch(6);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);
        graph.printGraph(graph.adj);
        System.out.println("breadthFirstSearch :- " + graph.breadthFirstSearch(2));
    }

    ArrayList<Integer> breadthFirstSearch(int source) {

        boolean visited[] = new boolean[noOfVertices + 1];
        visited[source] = true;

        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(source);

        ArrayList<Integer> bfsList = new ArrayList<>();
        while (queue.size() != 0) {
            int cur = queue.poll();
            bfsList.add(cur);

            for (Integer eachVertex : adj[cur]) {
                if (!visited[eachVertex]) {
                    queue.add(eachVertex);
                    visited[eachVertex] = true;
                }
            }

//            ListIterator<Integer> listIterator = adj[cur].listIterator();
//            while (listIterator.hasNext()) {
//                int eachVertex = listIterator.next();
//                if (!visited[eachVertex]) {
//                    queue.add(eachVertex);
//                    visited[eachVertex] = true;
//                }
//            }
        }
        return bfsList;
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

    void addEdge(int source, int dest) {
        //Source to destination
        LinkedList<Integer> vertexList = adj[source];
        vertexList.add(dest);

        //destination to source
        LinkedList<Integer> destList = adj[dest];
        destList.add(source);

    }

    public void printGraph(LinkedList<Integer> adjList[]) {

        for (int i = 0; i < adjList.length - 1; i++) {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print("-> " + adjList[i].get(j));
            }
            System.out.println();
        }
    }
}
