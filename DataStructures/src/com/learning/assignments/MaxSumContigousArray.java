package com.learning.assignments;

public class MaxSumContigousArray {


    static int maxSubContigousArraySum(int arr[]) {
        int currentMaximum = Integer.MIN_VALUE;
        int intermediateMaxSum = 0;
        for (int eachValue : arr) {
            intermediateMaxSum = intermediateMaxSum + eachValue;

            if (currentMaximum < intermediateMaxSum) {
                currentMaximum = intermediateMaxSum;
            }

            if (intermediateMaxSum < 0) {
                intermediateMaxSum = 0;
            }

            System.out.println("intermediateMaxSum :- " + intermediateMaxSum + " currentMaximum :- " + currentMaximum);
        }
        return currentMaximum;
    }

    public static void main(String[] args) {
        int arr[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum sum in the array contigously is :- " + maxSubContigousArraySum(arr));
    }

}
