package com.learning.dp.mcm;

public class MatrixChainMultiplication {

    public static void main(String[] args) {
        int answer = solve(new int[]{40, 20, 30, 10, 30}, 1, 4);
        System.out.println("Minimum number of multiplications is " + answer);
        int answer2 = solve(new int[]{1, 2, 3, 4, 3}, 1, 4);
        System.out.println("Minimum number of multiplications is " + answer2);
    }

    static int solve(int arr[], int i, int j) {
        if (i >= j) {
            return 0;
        }

        int minCost = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int tempAnswer = solve(arr, i, k)
                    + solve(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];

            System.out.println("tempAnswer :- " + tempAnswer);

            if (tempAnswer < minCost)
                minCost = tempAnswer;
        }
        return minCost;
    }

    static int solveMemoized(int arr[], int i, int j, int memo[][]) {

        if (i >= j) {
            return 0;
        }

        if (memo[i][j] != -1)
            return memo[i][j];

        memo[i][j] = Integer.MAX_VALUE;

        for (int k = i; k < j; k++) {
            int tempAnswer = solve(arr, i, k)
                    + solve(arr, k + 1, j)
                    + arr[i - 1] * arr[k] * arr[j];

            memo[i][j] = Math.min(memo[i][j], tempAnswer);
        }
        return memo[i][j];
    }
}
