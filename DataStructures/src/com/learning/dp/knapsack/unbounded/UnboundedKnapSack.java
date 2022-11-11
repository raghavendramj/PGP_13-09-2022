package com.learning.dp.knapsack.unbounded;

public class UnboundedKnapSack {


    public static void main(String[] args) {
        int profit[] = new int[]{25, 30, 15};
        int weights[] = new int[]{15, 5, 10};
        int maxCapacity = 100;
        int noOfItems = profit.length;
        System.out.println("unboundedKnapSackRecursive :- " + unboundedKnapSackRecursive(weights, profit, maxCapacity, noOfItems));


        int dp[][] = new int[noOfItems + 1][maxCapacity + 1];
        for (int i = 0; i < noOfItems; i++) {
            for (int j = 0; j < maxCapacity; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("unboundedKnapSackMemoization :- " + unboundedKnapSackMemoization(weights, profit, maxCapacity, noOfItems, dp));
        System.out.println("unboundedKnapSackTabulation :- " + unboundedKnapSackTabulation(weights, profit, maxCapacity, noOfItems));
    }

    static int unboundedKnapSackRecursive(int[] wt, int[] pf, int mw, int n) {

        //Base case -> Minimum valid input
        if (n == 0 || mw == 0) {
            return 0;
        }

        if (wt[n - 1] > mw) {
            return unboundedKnapSackRecursive(wt, pf, mw, n - 1);
        } else {
            int reducedMaxWeight = mw - wt[n - 1];
            int pick = pf[n - 1] + unboundedKnapSackRecursive(wt, pf, reducedMaxWeight, n); //Repeat yourself n -> n
            int notPick = unboundedKnapSackRecursive(wt, pf, mw, n - 1);
            return Math.max(pick, notPick);
        }
    }

    static int unboundedKnapSackMemoization(int[] wt, int[] pf, int mw, int n, int memo[][]) {

        //Base case -> Minimum valid input
        if (n == 0 || mw == 0) {
            return 0;
        }

        if (memo[n][mw] != -1)
            return memo[n][mw];

        if (wt[n - 1] > mw) {
            memo[n][mw] = unboundedKnapSackRecursive(wt, pf, mw, n - 1);
        } else {
            int reducedMaxWeight = mw - wt[n - 1];
            int pick = pf[n - 1] + unboundedKnapSackRecursive(wt, pf, reducedMaxWeight, n); //Repeat yourself n -> n
            int notPick = unboundedKnapSackRecursive(wt, pf, mw, n - 1);
            memo[n][mw] = Math.max(pick, notPick);
        }
        return memo[n][mw];
    }

    static int unboundedKnapSackTabulation(int[] wt, int[] pf, int mw, int n) {

        //Base case -> Minimum valid input
        if (n == 0 || mw == 0) {
            return 0;
        }
        int dp[][] = new int[n + 1][mw + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < mw + 1; j++) {
                if (wt[i - 1] > mw) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    int reducedMaxWeight = j - wt[i - 1];
                    int pick = pf[i - 1] + dp[i][reducedMaxWeight]; //Repeat yourself! -> call for all items again and again
                    int notPick = dp[i - 1][j];
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][mw];
    }
}
