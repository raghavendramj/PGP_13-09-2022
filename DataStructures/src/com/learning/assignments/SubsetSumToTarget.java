package com.learning.assignments;

public class SubsetSumToTarget {

    static boolean subSetSumRecursive(int set[], int n, int sum) {
        //Base Cases
        if (sum == 0)
            return true;
        if (n == 0 || sum < 0)
            return false;
        if (set[n - 1] <= sum) {
            int reducedSum = sum - set[n - 1];
            return subSetSumRecursive(set, n - 1, reducedSum) || subSetSumRecursive(set, n - 1, sum);
        } else {
            return subSetSumRecursive(set, n - 1, sum);
        }
    }

    static boolean subSetSumMemoization(int set[], int n, int sum, boolean memo[][]) {
        //Base Cases
        if (sum == 0)
            return true;
        if (n == 0 || sum < 0)
            return false;

        //Memo -> Check and return
        if (memo[n][sum]) {
            return memo[n][sum];
        }

        if (set[n - 1] <= sum) {
            int reducedSum = sum - set[n - 1];
            memo[n][sum] = subSetSumMemoization(set, n - 1, reducedSum, memo) || subSetSumMemoization(set, n - 1, sum, memo);
        } else {
            memo[n][sum] = subSetSumMemoization(set, n - 1, sum, memo);
        }
        return memo[n][sum];
    }

    static boolean subSetSumTabulation(int set[], int n, int sum) {

        boolean result[][] = new boolean[sum + 1][n + 1];

        //First column should be true. we can form 0 as sum, with empty {}
        for (int i = 0; i <= n; i++) {
            result[0][i] = true;
        }

        //Rest is false, because, we can't form 0 with any of the sum.
        for (int i = 1; i <= sum; i++) {
            result[i][0] = false;
        }

        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                result[i][j] = result[i][j - 1];
                if (i >= set[j - 1]) {
                    int reducedSum = i - set[j - 1];
                    result[i][j] = result[i][j] || result[reducedSum][j - 1];
                }
            }
        }
        return result[sum][n];
    }

    public static void main(String[] args) {
        int set[] = {3, 4, 5, 2};
        int sum = 9;
        int noOfElements = 4;

        if (subSetSumRecursive(set, noOfElements, sum)) {
            System.out.println("Recursion :- Found a valid subset!");
        } else {
            System.out.println("Recursion :- Can't find a valid subset!");
        }

        boolean dp[][] = new boolean[noOfElements + 1][sum + 1];

        if (subSetSumMemoization(set, noOfElements, sum, dp)) {
            System.out.println("Memoization :- Found a valid subset!");
        } else {
            System.out.println("Memoization :- Can't find a valid subset!");
        }

        if (subSetSumTabulation(set, noOfElements, sum)) {
            System.out.println("Tabulation :- Found a valid subset!");
        } else {
            System.out.println("Tabulation :- Can't find a valid subset!");
        }

    }
}
