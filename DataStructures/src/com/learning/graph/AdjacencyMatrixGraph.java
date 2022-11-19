package com.learning.graph;


public class AdjacencyMatrixGraph {

    int adjMatrix[][];
    int noOfVertices;

    public AdjacencyMatrixGraph(int noOfVertices) {
        this.noOfVertices = noOfVertices;
        this.adjMatrix = new int[noOfVertices][noOfVertices];
    }

    public static void main(String[] args) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(6);
        graph.addEdge(1, 5);
        graph.addEdge(1, 2);
        graph.addEdge(1, 4);
        graph.addEdge(2, 4);

        graph.addEdge(4, 5);
        graph.addEdge(5, 3);

        System.out.println(graph.toString());

    }

    void addEdge(int source, int dest) {
        adjMatrix[source][dest] = 1;
        adjMatrix[dest][source] = 1;
    }

    void removeEdge(int source, int dest) {
        adjMatrix[source][dest] = 0;
        adjMatrix[dest][source] = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < noOfVertices; i++) {
            sb.append(i + " :- ");
            for (int j = 1; j < noOfVertices; j++) {
                sb.append(adjMatrix[i][j] + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }


}
