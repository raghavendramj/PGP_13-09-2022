package com.learning;

public class LargeSumContigous {

    static int maxSubArraySum(int arr[]) {
        int maxCurr = Integer.MIN_VALUE;
        int maxTillNow = 0;
        for (int i = 0; i < arr.length; i++) {

            maxTillNow += arr[i];

            System.out.println("maxCurr :- "+ maxCurr + " maxTillNow -> "+ maxTillNow);
            if (maxCurr < maxTillNow) {
                maxCurr = maxTillNow;
            }

            if (maxTillNow < 0) {
                maxTillNow = 0;
            }
        }
        return maxCurr;
    }

    public static void main(String[] args) {
        int[] a = {-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is "
                + maxSubArraySum(a));

    }
}
