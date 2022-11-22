package com.learning.graph;

import java.util.LinkedList;
import java.util.List;

public class DetectCycleInADirectedGraph {

    static int noOfVertices;
    LinkedList<Integer> adj[];

    public DetectCycleInADirectedGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        DetectCycleInADirectedGraph graph = new DetectCycleInADirectedGraph(5);
        graph.addEdge(0, 1);
        graph.addEdge(2, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 2);

        graph.printDirectedGraphElements(graph.adj);
    }

    boolean isCyclic(int vertex, List<Integer> adj[]) {
        boolean visited[] = new boolean[noOfVertices];
        boolean recS[] = new boolean[noOfVertices];

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                int currentVertex = i;
                if (dfs(currentVertex, adj, visited, recS)) {
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(int currentVertex, List<Integer>[] adj, boolean[] visited, boolean[] recS) {
        visited[currentVertex] = true;
        recS[currentVertex] = true;

        List<Integer> adjList = adj[currentVertex];
        for (int eachNode : adjList) {
            if (!visited[eachNode]) {
                if (dfs(eachNode, adj, visited, recS)) {
                    return true;
                }
            } else if (recS[eachNode]) {
                return true;
            }
        }
        recS[currentVertex] = false;
        return true;
    }

    void addEdge(int source, int dest) {
        //Source to destination
        LinkedList<Integer> vertexList = adj[source];
        vertexList.add(dest);
    }

    public void printDirectedGraphElements(LinkedList<Integer> adjList[]) {

        for (int i = 0; i < adjList.length; i++) {
            System.out.print("Vertex " + i + " :");
            for (int j = 0; j < adjList[i].size(); j++) {
                System.out.print("-> " + adjList[i].get(j));
            }
            System.out.println();
        }
    }
}
