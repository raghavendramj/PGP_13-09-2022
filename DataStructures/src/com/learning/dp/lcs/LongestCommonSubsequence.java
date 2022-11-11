package com.learning.dp.lcs;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String s1 = "ABCDGH";
        String s2 = "AEDFHR";

        char x[] = s1.toCharArray();
        char y[] = s2.toCharArray();
        int m = x.length;
        int n = y.length;

        System.out.println("Recursion :- Length of Longest Common subsequence is :- " + longestCommonSubSequence(x, y, m, n));

        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println("Memoization :- Length of Longest Common subsequence is :- " + longestCommonSubSequenceMemoized(x, y, m, n, dp));

        System.out.println("Tabulation :- Length of Longest Common subsequence is :- " + longestCommonSubSequenceTabulation(x, y, m, n));
    }

    static int longestCommonSubSequenceTabulation(char[] x, char[] y, int m, int n) {
        //Base case -> LCS -> if one of the string is empty means, 0
        if (m == 0 || n == 0)
            return 0;

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int first = dp[i][j - 1];
                    int second = dp[i - 1][j];
                    dp[i][j] = Math.max(first, second);
                }
            }
        }
        return dp[m][n];
    }

    static int longestCommonSubSequence(char[] x, char[] y, int m, int n) {
        //Base case -> LCS -> if one of the string is empty means, 0
        if (m == 0 || n == 0)
            return 0;
        //index comparision
        if (x[m - 1] == y[n - 1]) {
            //System.out.println(x[m - 1]);
            return 1 + longestCommonSubSequence(x, y, m - 1, n - 1);
        } else {
            //Considering one string's one character, check for all the characters on the other string.
            int first = longestCommonSubSequence(x, y, m, n - 1);
            int second = longestCommonSubSequence(x, y, m - 1, n);
            return Math.max(first, second);
        }
    }

    static int longestCommonSubSequenceMemoized(char[] x, char[] y, int m, int n, int dp[][]) {
        //Base case -> LCS -> if one of the string is empty means, 0
        if (m == 0 || n == 0)
            return 0;

        if (dp[m][n] != -1)
            return dp[m][n];

        //index comparision
        if (x[m - 1] == y[n - 1]) {
            dp[m][n] = 1 + longestCommonSubSequence(x, y, m - 1, n - 1);
        } else {
            //Considering one string's one character, check for all the characters on the other string.
            int first = longestCommonSubSequence(x, y, m, n - 1);
            int second = longestCommonSubSequence(x, y, m - 1, n);
            dp[m][n] = Math.max(first, second);
        }
        return dp[m][n];
    }
}