package com.learning.dp.knapsack.zeroone;

public class ZeroOneKnapSack {


    static int knapSackRecursive(int wt[], int pf[], int mw, int n) {
        //Base condition!
        if (mw == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= mw) {
            int reducedMaxWeight = mw - wt[n - 1]; //Remove currently considered weight's profit.
            int pick = pf[n - 1] + knapSackRecursive(wt, pf, reducedMaxWeight, n - 1); //Profit for current weight
            int notPick = knapSackRecursive(wt, pf, mw, n - 1);
            return Math.max(pick, notPick);

//            return Math.max(pf[n - 1] + knapSackRecursive(wt, pf, mw - wt[n - 1], n - 1),
//                    knapSackRecursive(wt, pf, mw, n - 1));
        } else {
            return knapSackRecursive(wt, pf, mw, n - 1);
        }
    }

    static int knapSackMemoization(int wt[], int pf[], int mw, int n, int memo[][]) {
        //Base condition!
        if (mw == 0 || n == 0)
            return 0;

        //Memo -> Check and return
        if (memo[n][mw] != -1) {
            return memo[n][mw];
        }

        if (wt[n - 1] <= mw) {
            int reducedMaxWeight = mw - wt[n - 1]; //Remove currently considered weight's profit.
            int profit = pf[n - 1] + knapSackMemoization(wt, pf, reducedMaxWeight, n - 1, memo); //Profit for current weight
            memo[n][mw] = Math.max(profit, knapSackMemoization(wt, pf, mw, n - 1, memo));
        } else {
            memo[n][mw] = knapSackMemoization(wt, pf, mw, n - 1, memo);
        }
        return memo[n][mw];
    }

    static int knapSackTabulation(int wt[], int pf[], int mw, int n) {
        //Base condition!
        if (mw == 0 || n == 0)
            return 0;

        int dp[][] = new int[n + 1][mw + 1];

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < mw + 1; j++) {

                if (wt[i - 1] <= j) {
                    int reducedMaxWeight = j - wt[i - 1];
                    int curProfit = pf[i - 1] + dp[i - 1][reducedMaxWeight];
                    dp[i][j] = Math.max(curProfit, dp[i - 1][j]);
                    //dp[i][j] = Math.max(pf[n - 1] + dp[i - 1][j - wt[n - 1]], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][mw];

    }


    public static void main(String[] args) {
//        int profits[] = {1, 2, 5, 6};
//        int weights[] = {2, 3, 4, 5};
//        int maxWeight = 8;
//        int numberOfItems = 4;

        int profits[] = {60, 100, 120};
        int weights[] = {10, 20, 30};
        int maxWeight = 50;
        int numberOfItems = 3;
        int maxProfit = knapSackRecursive(weights, profits, maxWeight, numberOfItems);
        System.out.println("Recursion:- Maximum Profit is :- " + maxProfit);

        int dp[][] = new int[numberOfItems + 1][maxWeight + 1];
        for (int i = 0; i < numberOfItems + 1; i++) {
            for (int j = 0; j < maxWeight + 1; j++) {
                dp[i][j] = -1;
            }
        }
        maxProfit = knapSackMemoization(weights, profits, maxWeight, numberOfItems, dp);
        System.out.println("Memoization:- Maximum Profit is :- " + maxProfit);

        maxProfit = knapSackTabulation(weights, profits, maxWeight, numberOfItems);
        System.out.println("Tabulation:- Maximum Profit is :- " + maxProfit);
    }
}
