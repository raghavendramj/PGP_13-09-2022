package com.learning.assignments;

import java.util.Arrays;

public class MaximumStolenValueorHouseRobber {

    static int maxStolenValue(int houseValues[], int n) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return houseValues[n];
        }

        int firstPick = houseValues[n] + maxStolenValue(houseValues, n - 2);
        int nexPick = maxStolenValue(houseValues, n - 1);
        int maxValue = Math.max(firstPick, nexPick);
        return maxValue;
    }


    static int maxStolenMemo(int houseValues[], int n, int dp[]) {
        if (n < 0) {
            return 0;
        }

        if (n == 0) {
            return houseValues[n];
        }

        if (dp[n] != 1)
            return dp[n];

        int firstPick = houseValues[n] + maxStolenValue(houseValues, n - 2);
        int nexPick = maxStolenValue(houseValues, n - 1);
        int maxValue = Math.max(firstPick, nexPick);
        dp[n] = maxValue;
        return dp[n];
    }


    static int maxStolenTabulation(int houseValues[], int n) {

        if (n == 0)
            return 0;

        if (n == 1)
            return houseValues[0];

        if (n == 2)
            return Math.max(houseValues[0], houseValues[1]);

        int dp[] = new int[n];
        Arrays.fill(dp, 0);
        dp[0] = houseValues[0];
        dp[1] = houseValues[1];

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(houseValues[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }


    public static void main(String[] args) {
        int arr[] = {6, 7, 1, 3, 8, 2, 4};
        int result = maxStolenValue(arr, arr.length - 1);
        System.out.println("Maximum stolen value :- " + result);

        int tabResult = maxStolenTabulation(arr, arr.length);
        System.out.println("Maximum stolen value using tabulation :- " + tabResult);
    }
}
