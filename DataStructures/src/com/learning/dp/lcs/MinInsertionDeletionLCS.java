package com.learning.dp.lcs;

public class MinInsertionDeletionLCS {
    public static void main(String[] args) {
        String str1 = new String("heap");
        String str2 = new String("pea");

        minInsertionsAndDeletions(str1, str2);
    }

    static int lcs(char[] x, char[] y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;

        int dp[][] = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (x[i - 1] == y[j - 1]) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    int pick = dp[i - 1][j];
                    int notPick = dp[i][j - 1];
                    dp[i][j] = Math.max(pick, notPick);

                }
            }
        }
        return dp[m][n];
    }

    static void minInsertionsAndDeletions(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();
        int m = s1.length;
        int n = s2.length;
        int lcsCount = lcs(s1, s2, m, n);
        System.out.println("LCS :- " + lcsCount);
        System.out.println("Deletions :- " + Math.abs(m - lcsCount));
        System.out.println("Insertions :- " + Math.abs(n - lcsCount));
    }
}
