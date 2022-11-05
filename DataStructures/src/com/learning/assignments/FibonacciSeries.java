package com.learning.assignments;

import java.util.Arrays;
import java.util.HashMap;

public class FibonacciSeries {

    static int fibonacci(int n) {
        if (n <= 1)
            return n;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static long fibonacciMemoMap(long n, HashMap<Long, Long> memo) {
        //Base Case.
        if (n <= 1)
            return n;

        if (memo.containsKey(n))
            return memo.get(n);

        long result = fibonacciMemoMap(n - 1, memo) + fibonacciMemoMap(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    static long fibonacciMemoArray(int n, long dp[]) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];

        dp[n] = fibonacciMemoArray(n - 1, dp) + fibonacciMemoArray(n - 2, dp);
        return dp[n];
    }

    //Bottom Up Approach
    static long fibonacciTabulation(long n) {
        long prev2 = 0;
        long prev1 = 1;

        for (int i = 2; i <= n; i++) {
            long curr = prev2 + prev1;
            prev2 = prev1;
            prev1 = curr;
            //System.out.println("curr -> " + curr + " prev1 -> " + prev1 + " prev2 -> " + prev2);
        }

        return prev1;
    }

    public static void main(String[] args) {
        int numberToFind = 75;
        //System.out.println("Fibonacci of " + numberToFind + " :- " + fibonacci(numberToFind));
        System.out.println("Fibonacci using memo-map of " + numberToFind + " :- " + fibonacciMemoMap(numberToFind, new HashMap<>()));

        long dp[] = new long[numberToFind + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci using memo-array of " + numberToFind + " :- " + fibonacciMemoArray(numberToFind, dp));
        System.out.println("Fibonacci using tabulation of " + numberToFind + " :- " + fibonacciTabulation(numberToFind));


    }
}
