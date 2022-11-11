package com.learning.dp.lcs;

public class LongestRepeatingSubsequence {


    static int lrsRecursion(char[] inp, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        if (inp[m - 1] == inp[n - 1] && m != n) {
            return 1 + lrsRecursion(inp, m - 1, n - 1);
        } else {
            int first = lrsRecursion(inp, m - 1, n);
            int second = lrsRecursion(inp, m, n - 1);
            return Math.max(first, second);
        }
    }

    static int lrsMemoization(char[] inp, int m, int n, int memo[][]) {
        if (m == 0 || n == 0)
            return 0;

        if (memo[m][n] != -1)
            return memo[m][n];

        if (inp[m - 1] == inp[n - 1] && m != n) {
            memo[m][n] = 1 + lrsMemoization(inp, m - 1, n - 1, memo);
        } else {
            int first = lrsMemoization(inp, m - 1, n, memo);
            int second = lrsMemoization(inp, m, n - 1, memo);
            memo[m][n] = Math.max(first, second);
        }

        return memo[m][n];
    }

    static int lrsTabulation(String input) {

        char[] inp = input.toCharArray();
        int m = inp.length;
        int n = inp.length;


        if (m == 0 || n == 0)
            return 0;

        int dp[][] = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                //The same character if present in different index means, they are repeated
                if (inp[i - 1] == inp[j - 1] && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int first = dp[i - 1][j];
                    int second = dp[i][j - 1];
                    dp[i][j] = Math.max(first, second);
                }
            }
        }
        return dp[m][n];
    }


    static int longestRepeatingSubSeqeunce(String str) {

        int n = str.length();
        char[] x = str.toCharArray();
        if (n == 0)
            return 0;

        int dp[][] = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == x[j - 1] && i != j) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int pick = dp[i - 1][j];
                    int notPick = dp[i][j - 1];
                    dp[i][j] = Math.max(pick, notPick);
                }
            }
        }
        return dp[n][n];
    }

    public static void main(String[] args) {
        String str = "aabb";
        System.out.println("The length of the largest subsequence that"
                + " repeats itself is : " + longestRepeatingSubSeqeunce(str));
    }
}
