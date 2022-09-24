package com.learning.in.classassignments;

public class SearchInRotatedSortedNumbers {

    public static void main(String[] args) {
        int nums[] = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println("The pivot elements:- " + find_rotated_index(0, nums.length - 1, nums));
    }

    static int search(int nums[], int target) {
        int pivotIndex = find_rotated_index(0, nums.length - 1, nums);

        //Binary Search
        //target -> 1
        // 1, 2, 3, 4, 5, 6, 7 -> pivotIndex -> will be zero,
        // 4, 5, 6, 7, 1, 2, 3 -> -> pivotIndex -> will be 4,
        //if pivotIndex is my element to find, or 1st element in the sorted array....
        if (nums[pivotIndex] == target) {
            return pivotIndex;
        }

        //The array is already sorted, then peform normal binary search....
        // 0, 1, 2, 3, 4, 5, 6, 7
        if (nums[pivotIndex] == 0) {
            return binarySearch(nums, 0, nums.length - 1);
        }

        //target -> 1
        //4, 5, 6, 7, 1, 2, 3
        //pivotIndex -> 4
        // 1 < 4
        if (target < nums[0]) {
            return binarySearch(nums, pivotIndex, nums.length - 1);
        } else {
            //target -> 5
            //4, 5, 6, 7, 1, 2, 3
            //pivotIndex -> 4
            // 1 < 4
            return binarySearch(nums, 0, pivotIndex);
        }
    }

    static int binarySearch(int[] nums, int low, int high) {
        return -1;
        //typical binary search
    }

    static int find_rotated_index(int left, int right, int nums[]) {

        //Sorted numbers...
        if (nums[left] < nums[right]) {
            return 0;
        }
        //4,5,6,7,0,1,2

        while (left <= right) {
            int pivot = (left + right) / 2;

            if (nums[pivot] > nums[pivot + 1]) {
                return pivot + 1;
            } else {
                if (nums[pivot] < nums[left]) {
                    right = pivot - 1;
                } else {
                    left = pivot + 1;
                }
            }
        }
        return 0;
    }
}
