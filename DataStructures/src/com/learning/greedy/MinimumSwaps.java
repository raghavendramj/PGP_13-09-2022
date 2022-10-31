package com.learning.greedy;

import java.util.ArrayList;

public class MinimumSwaps {

    static long swapCount(String s) {
        ArrayList<Integer> openIdx = new ArrayList<>();

        char arr[] = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[') {
                openIdx.add(i);
            }
        }
        System.out.println("Opening Brackets :- " + openIdx);

        int idx = 0;
        int ans = 0;
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '[') {
                count++;
                idx++;
            } else {
                count--;
                if (count < 0) {
                    System.out.println("Current Swaps required:- " + (openIdx.get(idx) - i));
                    ans += openIdx.get(idx) - i;
                    swap(arr, i, openIdx.get(idx));
                    count = 1;
                    idx++;
                }
            }
        }
        return ans;

    }

    public static void main(String[] args) {
        System.out.println("swapCount required :- " + swapCount("]][[][][[[]]["));
        System.out.println("swapCount required :- " + swapCount("[][][]"));
    }

    static void swap(char arr[], int from, int to) {
        char temp = arr[from];
        arr[from] = arr[to];
        arr[to] = temp;
    }
}
