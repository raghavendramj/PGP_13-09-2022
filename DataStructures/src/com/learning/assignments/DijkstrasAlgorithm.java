package com.learning.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstrasAlgorithm {

    static int[] dijkstra(int vertex, int source, ArrayList<ArrayList<ArrayList<Integer>>> adj) {

        boolean[] visited = new boolean[vertex];
        PriorityQueue<Pair> queue = new PriorityQueue<Pair>();
        queue.add(new Pair(source, 0));
        int answer[] = new int[vertex];
        Arrays.fill(answer, Integer.MAX_VALUE);

        answer[source] = 0;

        while (queue.size() != 0) {
            Pair curPair = queue.remove();

            int curVertex = curPair.vertex;
            if (visited[curVertex])
                continue;

            ArrayList<ArrayList<Integer>> neighbours = adj.get(curVertex);
            for (ArrayList<Integer> list : neighbours) {
                int neighbourVertex = list.get(0);
                int neighbourWeight = list.get(1);
                if (answer[neighbourVertex] > answer[neighbourVertex] + neighbourWeight) {
                    answer[neighbourVertex] = answer[neighbourVertex] + neighbourWeight;
                    queue.add(new Pair(neighbourVertex, answer[neighbourVertex]));
                }
            }

        }
        return answer;

    }


}
