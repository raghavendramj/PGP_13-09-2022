package com.learning.dp.lcs.palindrome;

import java.util.HashSet;

public class LongestPalindromeSubsequence {

    static HashSet<Character> set;

    static int longestCommonSubSequenceTabulation(char[] x, char[] y, int m, int n) {
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

    static int longestPalindromicSubSequence(String input){

        char x[] = input.toCharArray();
        char y[] = new StringBuilder(input).reverse().toString().toCharArray();

        int len = input.length();
        set = new HashSet<>();
        int longestLength = longestCommonSubSequenceTabulation(x, y, len, len);


        System.out.println(new String(x));
        System.out.println(new String(y));
        System.out.println("Length of longest palindrome subsequence :- "+ longestLength);
        System.out.println("Length of longest palindrome subsequence :- "+ set);
        return longestLength;

    }

    public static void main(String[] args) {
        longestPalindromicSubSequence("agbcba");
        longestPalindromicSubSequence("GEEKSFORGEEKS");

    }
}
