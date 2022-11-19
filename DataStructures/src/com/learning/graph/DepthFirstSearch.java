package com.learning.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class DepthFirstSearch {

    static int noOfVertices;
    LinkedList<Integer> adj[];

    public DepthFirstSearch(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        DepthFirstSearch graph = new DepthFirstSearch(9);
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(0, 3);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);


        graph.addEdge(5, 8);
        graph.addEdge(5, 6);
        graph.addEdge(6, 7);
        graph.addEdge(7, 8);


        graph.printGraph(graph.adj);

        boolean visited[] = new boolean[noOfVertices + 1];


        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                System.out.println("visited :- " + i);
                ArrayList<Integer> dfsList = new ArrayList<>();
                graph.depthFirstSearch(i, dfsList, visited);
                System.out.println("depthFirstSearch :- " + dfsList);
            }
        }
//        ArrayList<Integer> dfsList = new ArrayList<>();
//        graph.depthFirstSearch(2, dfsList, visited);
//        System.out.println("depthFirstSearch :- " + dfsList);

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

        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print("-> " + adjList[i].get(j));
            }
            System.out.println();
        }
    }

//    void depthFirstSearch(int vertex, ArrayList<Integer> dfsList, boolean visited[]) {
//        visited[vertex] = true;
//        dfsList.add(vertex);
//
//        for (Integer eachVertex : adj[vertex]) {
//            if (!visited[eachVertex]) {
//                depthFirstSearch(eachVertex, dfsList, visited);
//            }
//        }
//    }

    void depthFirstSearch(int vertex, ArrayList<Integer> dfsList, boolean visited[]) {
        visited[vertex] = true;
        dfsList.add(vertex);

        for (Integer eachVertex : adj[vertex]) {
            if (!visited[eachVertex]) {
                depthFirstSearch(eachVertex, dfsList, visited);
            }
        }
    }
}
