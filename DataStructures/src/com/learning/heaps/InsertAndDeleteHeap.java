package com.learning.heaps;

public class InsertAndDeleteHeap {

    static int HEAP_SIZE = 7;

    public static void main(String[] args) {


        InsertAndDeleteHeap heap = new InsertAndDeleteHeap();
        int arr[] = new int[HEAP_SIZE];

        int elements[] = {7, 9, 3, 4, 16, 90};
        for (int i = 0; i < elements.length; i++) {
            heap.insert(arr, i, elements[i]);
        }

        System.out.println("Elements Initially...");
        for (int i = HEAP_SIZE - 1; i >= 1; i--) {
            heap.printElements(arr);
            System.out.println("Deleted Element:- " + heap.deleteElement(arr, 6));
        }
        System.out.println("\nElements After all elements deleted  :- ");
        heap.printElements(arr);

    }

    void printElements(int arr[]) {
        System.out.print("-----------------------------");
        System.out.print("\nElements in the array :- ");
        for (int each : arr) {
            System.out.print(each + " ");
        }
        System.out.println();
    }

    void insert(int arr[], int n, int newValue) {
        n = n + 1;
        arr[n] = newValue;

        int i = n;
        while (i > 1) {
            int parent = i / 2;
            if (arr[parent] < arr[i]) {
                swap(arr, parent, i);
                i = parent;
            } else {
                return;
            }
        }
    }

    int deleteElement(int arr[], int n) {
        int deletedElement = arr[1];
        arr[1] = arr[n]; // Replacing the root with rightmost child
        arr[n] = 0;
        n = n - 1;
        int i = 1; //root
        while (i < n - 2) {
            int left = arr[2 * i];
            int right = arr[2 * i + 1];
            int largestIndex = left > right ? 2 * i : 2 * i + 1;
            if (arr[i] < arr[largestIndex]) {
                swap(arr, i, largestIndex);
                i = largestIndex;
            } else {
                return deletedElement;
            }
        }

        return deletedElement;
    }

    private void swap(int[] arr, int parent, int i) {
        int temp = arr[parent];
        arr[parent] = arr[i];
        arr[i] = temp;
    }
}
