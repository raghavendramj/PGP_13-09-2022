package com.learning.dp.knapsack.unbounded;

import java.util.Arrays;

public class CoinChangeI {

    public static void main(String[] args) {
        int[] coins = {1, 2, 3};
        int sum = 4;
        int n = coins.length;
        System.out.println("counCoinsRecursive :- " + countCoinsRecursive(coins, n, sum));


        int[][] dp = new int[n + 1][sum + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("coinchangeMemoization :- " + coinchangeMemoization(coins, sum, n, dp));

        System.out.println("coinchangeTabulation :- "+ coinchangeTabulation(coins, n, sum));
    }

    static long coinchangeTabulation(int coins[], int n, int sum) {
        // table[i] will be storing the number of solutions for
        // value i. We need sum+1 rows as the table is
        // constructed in bottom up manner using the base case
        // (sum = 0)
        int table[] = new int[sum + 1];

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to the
        // value of the picked coin
        for (int i = 0; i < n; i++) {
            for (int j = coins[i]; j <= sum; j++) {
                int updatedSum = j - coins[i];
                table[j] += table[updatedSum];
            }
        }

        return table[sum];
    }

    static int coinchangeMemoization(int[] coins, int sum, int n, int[][] memo) {
        if (sum == 0)
            return 1;

        if (n == 0)
            return 0;

        if (memo[n][sum] != -1)
            return memo[n][sum];

        if (coins[n - 1] <= sum) {
            // Either Pick this coin or not
            int updatedSum = sum - coins[n - 1];
            int pick = coinchangeMemoization(coins, updatedSum, n, memo);
            int notPick = coinchangeMemoization(coins, sum, n - 1, memo);
            memo[n][sum] = pick + notPick;

        } else {
            // We have no option but to leave this coin
            memo[n][sum] = coinchangeMemoization(coins, sum, n - 1, memo);
        }
        return memo[n][sum];
    }

    static int countCoinsRecursive(int[] coins, int n, int sum) {
        // 4 -> (Coin -> 2)sum=2 -> (Coin ->1)sum=1 -> (Coin ->1)sum=0
        // Base -> Sum -> 0
        if (sum == 0)
            return 1; // to increment the count of found comibinations

        if (sum < 0 || n == 0)
            return 0;

        int updatedSum = sum - coins[n - 1];
        int pick = countCoinsRecursive(coins, n, updatedSum); //Unbounded knapsack -> n and updated sum
        int notPick = countCoinsRecursive(coins, n - 1, sum);
        return pick + notPick;
    }
}
