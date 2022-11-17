package com.learning.dp.mcm;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String input = "ababbbabbababa";
        int noOfPartitions = minPalindromeCuts(input, 0, input.length() - 1);
        System.out.println("No of partitions are :- " + noOfPartitions);
        //String input = "ababbbabbababa";
        //minPalindromeCuts(input, 0, input.length() - 1);


    }

    static int minPalindromeCuts(String input, int i, int j) {

        //Base Condition If input is of only one character!
        if (i == j) {
            return 0;
        }
        //Base Condition If input more than one character
        if (i > j) {
            return 0;
        }
        //Our functionality case
        if (isPalindrome(input, i, j)) {
            return 0;
        }

        int minPalindromePartitions = Integer.MAX_VALUE;
        for (int k = i; k <= j - 1; k++) {
            //1 -> because we are already paritioning from i to k and k+1 to j
            int partitions = minPalindromeCuts(input, i, k) + 1 + minPalindromeCuts(input, k + 1, j);
            minPalindromePartitions = Math.min(minPalindromePartitions, partitions);
        }

        return minPalindromePartitions;
    }

    private static boolean isPalindrome(String input, int i, int j) {
        while (i < j) {
            if (input.charAt(i) != input.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
