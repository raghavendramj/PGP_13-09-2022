package com.learning.assignments;

public class LongestPalindromeSubsequence {

    public static void main(String[] args) {

        String input = "agbcba";
        System.out.println("Longest Palindromic Subsequence of  " + input + " is :- " + lps(input));

        input = "bbabcbcab";
        System.out.println("Longest Palindromic Subsequence of  " + input + " is :- " + lps(input));
    }

    static int lps(String input) {
        char[] x = input.toCharArray();
        char[] y = new StringBuilder(input).reverse().toString().toCharArray();
        int m = input.length();
        int n = input.length();
        int lpsLength = lcs(x, y, m, n);
        return lpsLength;
    }

    static int lcs(char x[], char y[], int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
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
}
