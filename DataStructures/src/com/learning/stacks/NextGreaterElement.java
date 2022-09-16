package com.learning.stacks;

import java.util.Stack;

public class NextGreaterElement {

    static void printNextGreaterElement(int arr[]) {

        int n = arr.length;

        //Base condition
        if (n <= 1) {
            System.out.println("-1");
            return;
        }
        int result[] = new int[n];

        //4, 3, 5, 2, 25, 10
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                int peekedValue =  stack.peek();
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                result[i] = stack.peek();
            }
            stack.push(arr[i]); //10
        }
        System.out.println("\n Result is :- ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i] + " :- " + result[i]);
        }
    }

    public static void main(String[] args) {
        int arr[] = {4, 3, 5, 2, 25, 10};
        printNextGreaterElement(arr);
//        printNextGreaterElement(new int []{4, 5, 2, 25});
//        printNextGreaterElement(new int []{5, 1, 6, 2 , 8, 9, 3});

    }

}
