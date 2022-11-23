package com.learning.graph;

import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSorting {


    int noOfVertices;
    LinkedList<Integer> adj[];

    public TopologicalSorting(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        adj = new LinkedList[noOfVertices];
        for (int i = 0; i < noOfVertices; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public static void main(String[] args) {
        TopologicalSorting graph = new TopologicalSorting(6);
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        graph.printDirectedGraphElements(graph.adj);

        int[] topSortedArr = graph.topologicalSorting();

        System.out.println("Topological Sorted array is :- ");
        for (int each : topSortedArr) {
            System.out.print(each + "  ");
        }
        System.out.println();
    }

    int[] topologicalSorting() {
        boolean visited[] = new boolean[noOfVertices];
        Stack<Integer> topStack = new Stack<>();

        for (int i = 0; i < noOfVertices; i++) {
            if (!visited[i]) {
                dfs(i, adj, topStack, visited);
            }
        }

        int ans[] = new int[noOfVertices];
        int index = 0;
        while (!topStack.isEmpty()) {
            ans[index++] = topStack.pop();
        }

        return ans;
    }

    void dfs(int vertex, LinkedList<Integer> adj[], Stack<Integer> topStack, boolean[] visited) {
        visited[vertex] = true;
        LinkedList<Integer> adjacentList = adj[vertex];
        for (int currVertex : adjacentList) {
            if (!visited[currVertex]) {
                dfs(currVertex, adj, topStack, visited);
            }
        }
        topStack.push(vertex);
    }

    void addEdge(int source, int dest) {
        LinkedList<Integer> srcList = adj[source];
        srcList.add(dest);
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
