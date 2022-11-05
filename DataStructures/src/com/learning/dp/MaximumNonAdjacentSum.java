package com.learning.dp;

import java.util.Arrays;

public class MaximumNonAdjacentSum {


    public static void main(String[] args) {
        int arr[] = {2, 1, 4, 9};
        int dp[] = new int[arr.length];
        Arrays.fill(dp, -1);

        System.out.println("Maximum non adjacent sum is :- "+ maxNonAdjSum(arr.length -1, arr, dp));
    }

    static int maxNonAdjSum(int index, int arr[], int dp[]) {
        if (index < 0)
            return 0;
        if (index == 0)
            return arr[index];

        if (dp[index] != -1)
            return dp[index];

        int pick = arr[index] + maxNonAdjSum(index - 2, arr, dp);
        int nonPick = arr[index] + maxNonAdjSum(index - 1, arr, dp);

        return dp[index] = Math.max(pick, nonPick);
    }
}
