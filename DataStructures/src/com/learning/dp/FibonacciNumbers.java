package com.learning.dp;

import java.util.Arrays;
import java.util.HashMap;

public class FibonacciNumbers {

    // 0, 1, 1, 2, 3, 5, 8, 13,....
    static int fibonacci(int n) {
        if (n <= 1)
            return 1;
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    static Long fibonacciMemo(Long n, HashMap<Long, Long> memo) {
        if (n <= 1)
            return n;
        if (memo.containsKey(n))
            return memo.get(n);

        Long result = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        memo.put(n, result);
        return result;
    }

    static long fibonocciMemoArray(int n, long[] dp) {
        if (n <= 1)
            return n;

        if (dp[n] != -1)
            return dp[n];
        return dp[n] = fibonocciMemoArray(n - 1, dp) + fibonocciMemoArray(n - 2, dp);
    }

    static long fibonacciTabulation(long n) {
        long prev2 = 0;
        long prev = 1;

        for (int i = 2; i <= n; i++) {
            long cur_i = prev2 + prev;
            prev2 = prev;
            prev = cur_i;
        }
        return prev;
    }

    public static void main(String[] args) {
        //System.out.println("Fibonacci Value for 5 is :- " + fibonacci(45));
        System.out.println("Fibonacci Value for 55 is :- " + fibonacciMemo(55l, new HashMap<>()));
        System.out.println("Fibonacci Value for 55 is :- " + fibonacciTabulation(55));

        int n = 55;
        long dp[] = new long[n + 1];
        Arrays.fill(dp, -1);
        System.out.println("Fibonacci Value for 55 is :- " + fibonocciMemoArray(n, dp));

    }
}
