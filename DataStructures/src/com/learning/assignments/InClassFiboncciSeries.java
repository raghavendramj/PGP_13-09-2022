package com.learning.assignments;

//Dynamic Programming -> Advanced Recursion
//1. Recursive answer
//2. Memoize -> Top Down Approach
//3. Tabulation -> Bottom Down Approach

import java.util.HashMap;

// 0 1 1 2 3 5 8....
public class InClassFiboncciSeries {
    //1. Recursive answer
    static int fibonacci(int number) {
        if (number <= 1) {
            return 1;
        }
        return fibonacci(number - 1) + fibonacci(number - 2);
    }

    //2. Memoize -> Top Down Approach
    static Long fibonacciMemoized(Long number, HashMap<Long, Long> memo) {
        if (number <= 1) {
            return number;
        }

        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        Long answer = fibonacciMemoized(number - 1, memo) + fibonacciMemoized(number - 2, memo);
        memo.put(number, answer);
        return answer;
    }

    //3. Tabulation -> Bottom Down Approach
    static long fibonacciTabulation(long number) {

        if (number <= 1) {
            return number;
        }
        long fib1 = 0;
        long fib2 = 1;

        for (int i = 0; i <= number; i++) {
            long fib3 = fib2 + fib1;
            fib1 = fib2;
            fib2 = fib3;
        }
        System.out.println("Current Fibonccai Number :- " + fib2);
        return fib1;
    }

    public static void main(String[] args) {
        long n = 65;
        System.out.println("Fibonacci value for " + n + " :- " + fibonacciMemoized(n, new HashMap<>()));
    }


}
