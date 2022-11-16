package com.learning.dp.knapsack.zeroone;

public class KnapSack {


    static int knapSackRecursion(int w[], int profit[], int maxWeight, int n) {
        if (maxWeight == 0 || n == 0)
            return 0;
        if (w[n - 1] <= maxWeight)
            return Math.max(profit[n - 1] + knapSackRecursion(w, profit, maxWeight - w[n - 1], n - 1),
                    knapSackRecursion(w, profit, maxWeight, n - 1));
        else
            return knapSackRecursion(w, profit, maxWeight, n - 1);
    }

    static int knapSackDPMemoization(int w[], int profit[], int maxWeight, int n, int memo[][]) {
        if (maxWeight == 0 || n == 0)
            return 0;
        if (w[n - 1] <= maxWeight)
            memo[n][maxWeight] = Math.max(profit[n - 1] + knapSackDPMemoization(w, profit, maxWeight - w[n - 1], n - 1, memo),
                    knapSackDPMemoization(w, profit, maxWeight, n - 1, memo));
        else
            memo[n][maxWeight] = knapSackDPMemoization(w, profit, maxWeight, n - 1, memo);
        return memo[n][maxWeight];
    }


    static int knapSackDPTabulation(int wt[], int profit[], int maxWeight, int n) {
        if (maxWeight == 0 || n == 0)
            return 0;


        int dp[][] = new int[n + 1][maxWeight + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < maxWeight + 1; j++) {

                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (wt[i - 1] <= j)
                    dp[i][j] = Math.max(profit[i - 1] + dp[i - 1][j - wt[i - 1]], dp[i - 1][j]);
                else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][maxWeight];
    }

    public static void main(String[] args) {

        int val[] = new int[]{60, 100, 120};
        int wt[] = new int[]{10, 20, 30};
        int maxWeight = 50;
        int n = val.length;
        System.out.println("knapSack using recursion:- " + knapSackRecursion(wt, val, maxWeight, n));

        int dp[][] = new int[n + 1][maxWeight + 1];
        for (int i = 0; i < n + 1; i++)
            for (int j = 0; j < maxWeight + 1; j++)
                dp[i][j] = -1;
        System.out.println("knapSack using dynamic programming using memoization :- " + knapSackDPMemoization(wt, val, maxWeight, n, dp));

        System.out.println("knapSack using dynamic programming using tabulation :- " + knapSackDPTabulation(wt, val, maxWeight, n));

    }
}
