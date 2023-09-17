package com.learning.graph;

public class Pair implements Comparable<Pair> {
    public int vertex;
    public int weight;

    public Pair(int vertex, int weight) {
        this.vertex = vertex;
        this.weight = weight;
    }

    @Override
    public int compareTo(Pair that) {
        return this.weight - that.weight;
    }
}