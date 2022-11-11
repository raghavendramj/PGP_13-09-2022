package com.learning.assignments;

public class UnboundedKnapsack {

    static int unBoundedknapSackRecusrive(int maxCapacity, int weight[], int value[], int n) {

        if (n == 0 || maxCapacity == 0)
            return 0;

        if (weight[n - 1] > maxCapacity)
            return unBoundedknapSackRecusrive(maxCapacity, weight, value, n - 1);

        else {
            int take = value[n - 1] + unBoundedknapSackRecusrive(maxCapacity - weight[n - 1], weight, value, n);
            int notTake = unBoundedknapSackRecusrive(maxCapacity, weight, value, n - 1);
            return Math.max(take, notTake);
        }
    }


    static int unBoundedknapSackMemoization(int maxCapacity, int weight[], int value[], int n, int memo[][]) {

        if (n == 0 || maxCapacity == 0)
            return 0;

        if (memo[n][maxCapacity] != -1) {
            return memo[n][maxCapacity];
        }

        if (weight[n - 1] > maxCapacity)
            return unBoundedknapSackMemoization(maxCapacity, weight, value, n - 1, memo);

        else {
            int take = value[n - 1] + unBoundedknapSackMemoization(maxCapacity - weight[n - 1], weight, value, n, memo);
            int notTake = unBoundedknapSackMemoization(maxCapacity, weight, value, n - 1, memo);
            return Math.max(take, notTake);
        }
    }

    static int knapSackTabulation(int maxCapacity, int weight[], int value[], int n) {

        int K[][] = new int[n + 1][maxCapacity + 1];
        // creating table K[][] using bottom-up approach
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= maxCapacity; j++) {
                if (i == 0 || j == 0)
                    K[i][j] = 0;
                else if (weight[i - 1] <= j)
                    K[i][j] = Math.max(value[i - 1] + K[i][j - weight[i - 1]], K[i - 1][j]);
                else
                    K[i][j] = K[i - 1][j];
            }
        }
        return K[n][maxCapacity];
    }

    public static void main(String[] args) {
        int value[] = new int[]{25, 30, 15};
        int weight[] = new int[]{15, 5, 10};
        int maxCapacity = 100;
        int n = value.length;
        System.out.println("unBoundedknapSackRecusrive :- " + unBoundedknapSackRecusrive(maxCapacity, weight, value, n));

        int dp[][] = new int[n + 1][maxCapacity + 1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < maxCapacity + 1; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("unBoundedknapSackMemoization :- " + unBoundedknapSackMemoization(maxCapacity, weight, value, n, dp));
        System.out.println("knapSackTabulation :- " + knapSackTabulation(maxCapacity, weight, value, n));
    }
}
