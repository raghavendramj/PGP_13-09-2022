package com.learning.assignments;

import java.util.Arrays;

public class CoinChangeProblem {

    static int counCoinsRecursive(int coins[], int n, int sum) {

        if (sum == 0)
            return 1;
        if (sum < 0)
            return 0;
        if (n <= 0)
            return 0;

        return counCoinsRecursive(coins, n - 1, sum) + counCoinsRecursive(coins, n, sum - coins[n - 1]);
    }

    static int coinchangeMemoization(int[] coins, int sum, int n, int[][] dp) {
        if (sum == 0)
            return dp[n][sum] = 1;
        if (n == 0)
            return 0;
        if (dp[n][sum] != -1)
            return dp[n][sum];
        if (coins[n - 1] <= sum) {

            // Either Pick this coin or not
            return dp[n][sum]
                    = coinchangeMemoization(coins, sum - coins[n - 1], n, dp)
                    + coinchangeMemoization(coins, sum, n - 1, dp);
        } else // We have no option but to leave this coin
            return dp[n][sum] = coinchangeMemoization(coins, sum, n - 1, dp);
    }


    static long countTabulation(int coins[], int n, int sum) {
        int table[] = new int[sum + 1];
        table[0] = 1;
        for (int i = 0; i < n; i++)
            for (int j = coins[i]; j <= sum; j++)
                table[j] += table[j - coins[i]];

        return table[sum];
    }


    public static void main(String[] args) {

        int[] coins = {1, 2, 3};
        int sum = 4;
        int n = coins.length;
        System.out.println("counCoinsRecursive :- " + counCoinsRecursive(coins, n, sum));


        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("coinchangeMemoization :- " + coinchangeMemoization(coins, sum, n, dp));

    }
}
