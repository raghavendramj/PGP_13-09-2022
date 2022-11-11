package com.learning.dp.knapsack.zeroone;

public class CountSubsetSum {


    static int isSubsetSumRecursive(int set[], int n, int sum) {
        // Base Cases
        if (sum == 0)
            return 1;
        if (n == 0)
            return 0;

        // If last element is greater than sum, then ignore it
        if (set[n - 1] > sum)
            return isSubsetSumRecursive(set, n - 1, sum);

        /* else, check if sum can be obtained
        by any of the following
            (a) including the last element
            (b) excluding the last element */
        return isSubsetSumRecursive(set, n - 1, sum) + isSubsetSumRecursive(set, n - 1, sum - set[n - 1]);
    }

    static int isSubsetSumTabulation(int set[],
                                     int n, int sum) {
        // The value of subset[i][j] will be
        // true if there is a subset of
        // set[0..j-1] with sum equal to i
        int subset[][] = new int[sum + 1][n + 1];

        // If sum is 0, then answer is true
        for (int i = 0; i <= n; i++)
            subset[0][i] = 1;

        // If sum is not 0 and set is empty,
        // then answer is false
        for (int i = 1; i <= sum; i++)
            subset[i][0] = 0;

        // Fill the subset table in bottom
        // up manner
        for (int i = 1; i <= sum; i++) {
            for (int j = 1; j <= n; j++) {
                subset[i][j] = subset[i][j - 1];
                if (i >= set[j - 1]) {
                    subset[i][j] = subset[i][j] + subset[i - set[j - 1]][j - 1];
                }
            }
        }

        // uncomment this code to print table
        /*for (int i = 0; i <= sum; i++) {
            for (int j = 0; j <= n; j++) {
                System.out.print(subset[i][j] + "     ");
            }
            System.out.println();
        }*/

        return subset[sum][n];
    }

    public static void main(String[] args) {
        int set[] = {3, 34, 4, 12, 5, 2};
        int sum = 9;
        int n = set.length;
        int countOfSubSet = isSubsetSumRecursive(set, n, sum);
        if (countOfSubSet > 0)
            System.out.println("RECURSIVE : Number of subsets with given sum = " + sum + " is :- " + countOfSubSet);
        else
            System.out.println("No subset with  given sum");

        System.out.println("TABULATION : Number of subsets with given sum = " + sum + " is :- " + isSubsetSumTabulation(set, n, sum));


    }
}
