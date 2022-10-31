package com.learning.greedy;

public class MinProdSubset {

    static int minProductSubset(int arr[], int n) {
        if (n == 1)
            return arr[0];

        // 1. Count of negative numbers,
        // 2. Count of zeros,
        // 3. Maximum valued negative number,
        // 4. Minimum valued positive number, and
        // 5. Product of non-zero numbers

        int maxNegative = Integer.MIN_VALUE;
        int minPositiveNumber = Integer.MAX_VALUE;
        int negativeNumsCount = 0, zerosCount = 0;
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

            // find the minimum positive number
            if (arr[i] > 0 && arr[i] < minPositiveNumber)
                minPositiveNumber = arr[i];

            product *= arr[i];
        }

        // if there are all zeroes
        // or zero is present but no
        // negative number is present
        if (zerosCount == n || (negativeNumsCount == 0 && zerosCount > 0))
            return 0;

        // If there are all positive
        if (negativeNumsCount == 0)
            return minPositiveNumber;

        // If there are even number except zero of negative numbers
        if (negativeNumsCount % 2 == 0 && negativeNumsCount != 0) {

            // Otherwise result is product of
            // all non-zeros divided by maximum
            // valued negative.
            product = product / maxNegative;
        }

        return product;
    }

    public static void main(String[] args) {
        int arr[] = {-1, -1, -2, 4, 3};
        System.out.println("Minimum product subset of an array is :- "+ minProductSubset(arr, 5));

    }
}
