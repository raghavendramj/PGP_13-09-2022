package com.learning.heaps;

import java.util.PriorityQueue;

public class RelativeRanksInClass {

    //["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    public static void main(String[] args) {
        int arr[] = {10, 3, 8, 9, 4};
        RelativeRanksInClass relativeRanks = new RelativeRanksInClass();
        relativeRanks.findRelativeRanks(arr);
    }

    public String[] findRelativeRanks(int[] score) {
        int n = score.length;
        PriorityQueue<Integer> rankQueue = new PriorityQueue<>((a, b) -> score[b] - score[a]);
        for (int i = 0; i < n; i++) {
            rankQueue.add(i);
        }
        String result[] = new String[n];
        while (!rankQueue.isEmpty()) {
            System.out.println("Current Index :- " + rankQueue.poll());
        }

        int rank = 1;
        while (!rankQueue.isEmpty()) {
            int index = rankQueue.poll(); //Rank Index
            System.out.println("Current Index :- " + index);

            if (rank > 3) {
                result[index] = Integer.toString(rank);
            } else if (rank == 1) {
                result[index] = "Gold Medal";
            } else if (rank == 2) {
                result[index] = "Silver Medal";
            } else if (rank == 3) {
                result[index] = "Bronze Medal";
            }
            rank++;
        }

        for (int j = 0; j < score.length; j++) {
            System.out.print(result[j] + " ");
        }

        return result;

        // O(nlog(n))

    }
}
