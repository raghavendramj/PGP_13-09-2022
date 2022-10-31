package com.learning.greedy;

public class MaxProdSubset {
    public static void main(String[] args) {
        int arr[] = {-1, -1, -2, 4, 3};
        System.out.println("\n Maximum product subset of an array is :- " + maxProductSubset(arr, 5));
        System.out.println("\n Maximum product subset of an array is :- " + maxProductSubset(new int[]{-1, -1, -2, 4, 3}, 5));
        System.out.println("\n Maximum product subset of an array is :- " + maxProductSubset(new int[]{-1, 0}, 2));

    }

    private static int maxProductSubset(int[] arr, int n) {
        if (n == 1) {
            return arr[0];
        }
        // 1. Count of negative numbers,
        // 2. Count of zeros,
        // 3. Maximum valued negative number,
        // 4. Product of non-zero numbers

        int maxNegative = Integer.MIN_VALUE;
        int negativeNumsCount = 0;
        int zerosCount = 0;
        int product = 1;

        for (int i = 0; i < n; i++) {

            // if number is zero,count it but dont multiply
            if (arr[i] == 0) {
                zerosCount++;
                continue;
            }

            // count the negative numbers and find the max negative number
            if (arr[i] < 0) {
                negativeNumsCount++;
                maxNegative = Math.max(maxNegative, arr[i]);
            }

            product *= arr[i];
        }

        // if there are all zeroes
        // or zero is present but no
        // negative number is present
        if (zerosCount == n || (negativeNumsCount == 0 && zerosCount > 0))
            return 0;


        // If there are even number except zero of negative numbers
        if (negativeNumsCount % 2 == 1 && negativeNumsCount != 0) {

            //Only if negative nums and zero present means
            if (negativeNumsCount == 1 && zerosCount > 0 && zerosCount + negativeNumsCount == n)
                return 0;

            // Otherwise result is product of
            // all non-zeros divided by maximum
            // valued negative.
            product = product / maxNegative;
        }

        return product;
    }
}
